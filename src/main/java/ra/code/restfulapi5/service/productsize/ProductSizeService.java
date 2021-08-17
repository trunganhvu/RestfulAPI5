package ra.code.restfulapi5.service.productsize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductSize;
import ra.code.restfulapi5.repository.IProductSizeRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Service
public class ProductSizeService implements IProductSizeService{

    @Autowired
    private IProductSizeRepository productSizeRepository;

    /**
     * Get all product size
     * @return List ProductSize
     */
    @Cacheable(value = "productsizes", key = "'CACHE_KEY_PRODUCT_SIZES'", sync = true)
    @Override
    public Iterable<ProductSize> findAll() {
        return productSizeRepository.findAll();
    }

    /**
     * Get product size by id
     * @param id
     * @return ProductSize
     */
    @Cacheable(value = "productsize", key = "#id", sync = true)
    @Override
    public Optional<ProductSize> findById(Long id) {
        return productSizeRepository.findById(id);
    }

    /**
     * Save ProductSize
     * @param productSize
     * @return ProductSize
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productsizes", key = "'CACHE_KEY_PRODUCT_SIZES'",  beforeInvocation = true),
            @CacheEvict(value = "productsizes-in-producttype", key = "'CACHE_KEY_PRODUCT_SIZES_IN_PRODUCT_TYPE'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "productsize", key = "#productSize.productTypeId")
        }
    )
    @Override
    public ProductSize save(ProductSize productSize) {
        if (productSize.getProductSizeId() == null) {
            productSize.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productSize.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productSizeRepository.save(productSize);
    }

    /**
     * Delete Product Size by id
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productsizes", key = "'CACHE_KEY_PRODUCT_SIZES'"),
            @CacheEvict(value = "productsizes-in-producttype", key = "'CACHE_KEY_PRODUCT_SIZES_IN_PRODUCT_TYPE'"),
            @CacheEvict(value = "productsize", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        productSizeRepository.deleteById(id);
    }

    /**
     * Get all product size in product type
     * @param productTypeId
     * @return List ProductSize
     */
    @Cacheable(value = "productsizes-in-producttype", key = "'CACHE_KEY_PRODUCT_SIZES_IN_PRODUCT_TYPE'", sync = true)
    @Override
    public List<ProductSize> getProductSizeInProductType(Long productTypeId) {
        return productSizeRepository.getProductSizeInProductType(productTypeId);
    }
}
