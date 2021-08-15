package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.Header;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Repository
public interface IHeaderRepository extends JpaRepository<Header, Long> {

}
