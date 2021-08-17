package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.ProductSize;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Repository
public interface IProductSizeRepository extends JpaRepository<ProductSize, Long> {

    @Query(value = "select * from product_size " +
            "where product_type_id=?1", nativeQuery = true)
    public List<ProductSize> getProductSizeInProductType(@Param("productTypeId") Long productTypeId);
}
