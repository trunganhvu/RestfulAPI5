package ra.code.restfulapi5.service.productimage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductImage;
import ra.code.restfulapi5.repository.IProductImageRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/19
 */
@Service
public class ProductImageService implements IProductImageService{

    @Autowired
    private IProductImageRepository productImageRepository;

    /**
     * Get all product image
     * @return List product image
     */
    @Cacheable(value = "productimages", key = "'CACHE_KEY_PRODUCT_IMAGES'", sync = true)
    @Override
    public Iterable<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    /**
     * Get product image by id
     * @param id
     * @return Product image
     */
    @Cacheable(value = "productimage", key = "#id", sync = true)
    @Override
    public Optional<ProductImage> findById(Long id) {
        return productImageRepository.findById(id);
    }

    /**
     * Save product image
     * @param productImage
     * @return Product image
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productimages", key = "'CACHE_KEY_PRODUCT_IMAGES'", beforeInvocation = true)
        },
        put = {
            @CachePut(value = "productimage", key = "#productImage.productImageId")
        }
    )
    @Override
    public ProductImage save(ProductImage productImage) {
        if (productImage.getProductImageId() == null) {
            productImage.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productImage.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return null;
    }

    /**
     * Delete product image by id
     * @param id
     */
    @Caching(evict = {
            @CacheEvict(value = "productimages", key = "'CACHE_KEY_PRODUCT_IMAGES'"),
            @CacheEvict(value = "productimage", key = "#id")
    })
    @Override
    public void remove(Long id) {
        productImageRepository.deleteById(id);
    }
}
