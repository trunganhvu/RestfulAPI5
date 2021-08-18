package ra.code.restfulapi5.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.Product;
import ra.code.restfulapi5.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/18
 */
@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    /**
     * Get all product
     * @return List product
     */
    @Cacheable(value = "products", key = "'CACHE_KEY_PRODUCTS'", sync = true)
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Get product by id
     * @param id
     * @return Product
     */
    @Cacheable(value = "product", key = "#id", sync = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Save product
     * @param product
     * @return Product
     */
    @Caching(
        evict = {
            @CacheEvict(value = "products", key = "'CACHE_KEY_PRODUCTS'", beforeInvocation = true),
            @CacheEvict(value = "products-in-producttype",
                    key = "'CACHE_KEY_PRODUCTS_IN_PRODUCT_TYPE_' + #product.productTypeId.productTypeId",
                    beforeInvocation = true)
        },
        put = {
            @CachePut(value = "product", key = "#product.productId")
        }
    )
    @Override
    public Product save(Product product) {
        if (product.getProductId() == null) {
            product.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            product.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productRepository.save(product);
    }

    /**
     * Delete product by id
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "products", key = "'CACHE_KEY_PRODUCTS'"),
            @CacheEvict(value = "products-in-producttype", key = "'CACHE_KEY_PRODUCTS_IN_PRODUCT_TYPE_' + #id"),
            @CacheEvict(value = "product", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Get all product in product type
     * @param productTypeId
     * @return List Product
     */
    @Cacheable(value = "products-in-producttype", key = "'CACHE_KEY_PRODUCTS_IN_PRODUCT_TYPE_' + #productTypeId", sync = true)
    @Override
    public List<Product> getAllProductInProductType(Long productTypeId) {
        return productRepository.getAllProductInProductType(productTypeId);
    }
}
