package ra.code.restfulapi5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.code.restfulapi5.model.CategoryPost;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Repository
public interface ICategoryPostRepository extends JpaRepository<CategoryPost, Long> {

    /**
     * Get List Category Post by Category Id
     * @param id
     * @return CategoryPost
     */
    @Query(value = "select * from category_post cp " +
            "where cp.category_id = ?1", nativeQuery = true)
    public List<CategoryPost> getListCategoryPostById(@Param("id") Long id);

    /**
     * Get List Category Post display by Category Id
     * @param id
     * @param display
     * @return List Category Post
     */
    @Query(value = "select * from category_post cp " +
            "where cp.category_id = ?1 and cp.display = ?2",
            nativeQuery = true)
    public List<CategoryPost> getListCategoryPostDisplayInCategory(@Param("id") Long id,
                                                            @Param("display") int display);

    /**
     * Get list category post display
     * @param display
     * @return List Category Post
     */
    @Query(value = "select * from category_post cp " +
            "where cp.display = ?1",
            nativeQuery = true)
    public List<CategoryPost> getListCategoryPostDisplay(@Param("display") int display);
}
