package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.OrderCustomer;

/**
 * @author trunganhvu
 * 2021/08/20
 */
@Repository
public interface IOrderRepository extends JpaRepository<OrderCustomer, Long> {
}
