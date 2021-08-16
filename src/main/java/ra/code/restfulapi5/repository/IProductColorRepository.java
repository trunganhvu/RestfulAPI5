package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.ProductColor;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Repository
public interface IProductColorRepository extends JpaRepository<ProductColor, Long> {
}
