package ra.code.restfulapi5.service.categorypost;

import ra.code.restfulapi5.model.CategoryPost;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public interface ICategoryPostService extends IGeneralService<CategoryPost> {
    /**
     * Get list CategoryPost by Category id
     * @param id
     * @return List CategoryPost
     */
    public List<CategoryPost> getListCategoryPostById(Long id);

    /**
     * Get category post display in category
     * @param id
     * @return
     */
    public List<CategoryPost> getListCategoryPostDisplayInCategory(Long id);

    /**
     * Get list category post
     * @return List category post
     */
    public List<CategoryPost> getListCategoryPostDisplay();
}
