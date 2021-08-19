package ra.code.restfulapi5.service.productpromotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductPromotion;
import ra.code.restfulapi5.repository.IProductPromotionRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/19
 */
@Service
public class ProductPromotionService implements IProductPromotionService{

    @Autowired
    private IProductPromotionRepository productPromotionRepository;

    /**
     * Get all promotion
     * @return List promotion
     */
    @Cacheable(value = "productpromotions", key = "'CACHE_KEY_PRODUCT_PROMOTIONS'", sync = true)
    @Override
    public Iterable<ProductPromotion> findAll() {
        return productPromotionRepository.findAll();
    }

    /**
     * Get product promotion
     * @param id
     * @return ProductPromotion
     */
    @Cacheable(value = "productpromotion", key = "#id", sync = true)
    @Override
    public Optional<ProductPromotion> findById(Long id) {
        return productPromotionRepository.findById(id);
    }

    /**
     * Save product promotion
     * @param productPromotion
     * @return ProductPromotion
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productpromotions", key = "'CACHE_KEY_PRODUCT_PROMOTIONS'", beforeInvocation = true)
        },
        put = {
            @CachePut(value = "productpromotion", key = "#productPromotion.productPromotionId")
        }
    )
    @Override
    public ProductPromotion save(ProductPromotion productPromotion) {
        if (productPromotion.getProductPromotionId() == null) {
            productPromotion.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productPromotion.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productPromotionRepository.save(productPromotion);
    }

    /**
     * Delete product promotion
     * @param id
     */
    @Caching(evict = {
        @CacheEvict(value = "productpromotions", key = "'CACHE_KEY_PRODUCT_PROMOTIONS'"),
        @CacheEvict(value = "productpromotion", key = "#id")
    })
    @Override
    public void remove(Long id) {
        productPromotionRepository.deleteById(id);
    }
}
