package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.ProductImage;

/**
 * @author trunganhvu
 * 2021/08/19
 */
@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Long> {
}
