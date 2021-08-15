package ra.code.restfulapi5.service.producttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductType;
import ra.code.restfulapi5.repository.IProductTypeRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Service
public class ProductTypeService implements IProductTypeService{

    @Autowired
    private IProductTypeRepository productTypeRepository;

    /**
     * Get all product type
     * @return list ProductType
     */
    @Cacheable(value = "producttypes", key = "'CACHE_KEY_PRODUCTTYPES'", sync = true)
    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    /**
     * Get product type by id
     * @param id
     * @return ProductType
     */
    @Cacheable(value = "producttype", key = "#id", sync = true)
    @Override
    public Optional<ProductType> findById(Long id) {
        return productTypeRepository.findById(id);
    }

    /**
     * Save product type
     * @param productType
     * @return ProductType
     */
    @Caching(
        evict = {
            @CacheEvict(value = "producttypes", key = "'CACHE_KEY_PRODUCTTYPES'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "producttype", key = "#productType.productTypeId")
        }
    )
    @Override
    public ProductType save(ProductType productType) {
        if (productType.getProductTypeId() == null) {
            productType.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productType.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productTypeRepository.save(productType);
    }

    /**
     * Delete product type
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "producttypes", key = "'CACHE_KEY_PRODUCTTYPES'"),
            @CacheEvict(value = "producttype", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        productTypeRepository.deleteById(id);
    }
}
