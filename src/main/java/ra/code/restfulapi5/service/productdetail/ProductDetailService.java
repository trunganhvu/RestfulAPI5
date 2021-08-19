package ra.code.restfulapi5.service.productdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.ProductDetail;
import ra.code.restfulapi5.repository.IProductDetailRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/19
 */
@Service
public class ProductDetailService implements IProductDetailService{

    @Autowired
    private IProductDetailRepository productDetailRepository;

    /**
     * Get all product detail
     * @return List product detail
     */
    @Cacheable(value = "productdetails", key = "'CACHE_KEY_PRODUCT_DETAILS'", sync = true)
    @Override
    public Iterable<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    /**
     * Get product detail by id
     * @param id
     * @return Product detail
     */
    @Cacheable(value = "productdetail", key = "#id", sync = true)
    @Override
    public Optional<ProductDetail> findById(Long id) {
        return productDetailRepository.findById(id);
    }

    /**
     * Save product detail
     * @param productDetail
     * @return Product detail
     */
    @Caching(
        evict = {
            @CacheEvict(value = "productdetails", key = "'CACHE_KEY_PRODUCT_DETAILS'", beforeInvocation = true)
        },
        put = {
            @CachePut(value = "productdetail", key = "#productDetail.productDetailId")
        }
    )
    @Override
    public ProductDetail save(ProductDetail productDetail) {
        if (productDetail.getProductDetailId() == null) {
            productDetail.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            productDetail.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return productDetailRepository.save(productDetail);
    }

    /**
     * Delete product detail by id
     * @param id
     */
    @Caching(evict = {
        @CacheEvict(value = "productdetails", key = "'CACHE_KEY_PRODUCT_DETAILS'"),
        @CacheEvict(value = "productdetail", key = "#id")
    })
    @Override
    public void remove(Long id) {
        productDetailRepository.deleteById(id);
    }
}
