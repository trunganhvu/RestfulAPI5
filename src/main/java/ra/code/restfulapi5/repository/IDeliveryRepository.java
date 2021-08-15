package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.code.restfulapi5.model.Delivery;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public interface IDeliveryRepository extends JpaRepository<Delivery, Long> {

    /**
     * Get all delivery using
     * is_using = 1 (true)
     * @param code
     * @return List Delivery
     */
    @Query(value = "select * from delivery " +
            "where is_using = ?1", nativeQuery = true)
    public List<Delivery> getAllDeliveryUsing(@Param("code") int code);
}
