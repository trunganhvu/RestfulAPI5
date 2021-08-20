package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.OrderDetail;

/**
 * @author trunganhvu
 * 2021/08/20
 */
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
