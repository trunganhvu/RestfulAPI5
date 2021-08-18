package ra.code.restfulapi5.service.productcolor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductColor;
import ra.code.restfulapi5.repository.IProductColorRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Service
public class ProductColorService implements IProductColorService{

    @Autowired
    private IProductColorRepository productColorRepository;

    /**
     * Get all color
     * @return List ProductColor
     */
    @Cacheable(value = "productcolors", key = "'CACHE_KEY_PRODUCT_COLORS'", sync = true)
    @Override
    public Iterable<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

    /**
     * Get product color by id
     * @param id
     * @return ProductColor
     */
    @Cacheable(value = "productcolor", key = "#id", sync = true)
    @Override
    public Optional<ProductColor> findById(Long id) {
        return productColorRepository.findById(id);
    }

    /**
     * Save product color
     * @param productColor
     * @return ProductColor
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productcolors", key = "'CACHE_KEY_PRODUCT_COLORS'", beforeInvocation = true)
        },
        put = {
            @CachePut(value = "productcolor", key = "#productColor.productColorId")
        }
    )
    @Override
    public ProductColor save(ProductColor productColor) {
        if (productColor.getProductColorId() == null) {
            productColor.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productColor.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productColorRepository.save(productColor);
    }

    /**
     * Delete product color by id
     * @param id
     */
    @Caching(evict = {
        @CacheEvict(value = "productcolors", key = "'CACHE_KEY_PRODUCT_COLORS'"),
        @CacheEvict(value = "productcolor", key = "#id")
    })
    @Override
    public void remove(Long id) {
        productColorRepository.deleteById(id);
    }
}
