package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.code.restfulapi5.model.Product;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/18
 */
public interface IProductRepository extends JpaRepository<Product, Long> {

    /**
     * Get all product in product type
     * @param productTypeId
     * @return List Product
     */
    @Query(value = "select * from product " +
            "where product_type_id=?1", nativeQuery = true)
    public List<Product> getAllProductInProductType(@Param("productTypeId") Long productTypeId);
}
