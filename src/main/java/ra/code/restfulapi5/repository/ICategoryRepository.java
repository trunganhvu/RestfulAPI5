package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.common.util.ConvertData;
import ra.code.restfulapi5.model.Category;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Get Category by name use query
     * @param name
     * @return Category
     */
    @Query(value = "select * from Category c where c.category_image_default_name = ?1", nativeQuery = true)
    public Category findByName(@Param("name") String name);

    /**
     * Get category display
     * @param code
     * @return List category
     */
    @Query(value = "select * from Category c where c.display = ?1", nativeQuery = true)
    public List<Category> getCategoryDisplay(@Param("code") int code);
}
