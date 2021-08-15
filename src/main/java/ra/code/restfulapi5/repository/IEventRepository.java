package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.code.restfulapi5.model.Event;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public interface IEventRepository extends JpaRepository<Event, Long> {

    @Query(value = "select * from event " +
            "where active = ?1", nativeQuery = true)
    public List<Event> getEventActive(@Param("code") int code);
}
