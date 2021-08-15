package ra.code.restfulapi5.service.category;

import ra.code.restfulapi5.model.Category;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public interface ICategoryService extends IGeneralService<Category> {
    /**
     * Get Category by name
     * @param name
     * @return Category
     */
    public Category findByName(String name);

    /**
     * Get list category have display = 1 (true)
     * @return List Category
     */
    public List<Category> getCategoryDisplay();
}
