package ra.code.restfulapi5.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.common.variableconst.CommonConst;
import ra.code.restfulapi5.model.Category;
import ra.code.restfulapi5.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    /**
     * Get all
     * @return List Category
     */
    @Cacheable(value = "categories", key = "'CACHE_KEY_CATEGORIES'", sync = true)
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Get Category by id
     * @param id
     * @return Category
     */
    @Cacheable(value = "category", key = "#id", sync = true)
    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Save Category
     * @param category
     * @return Category
     */
    @Caching(
        evict = {
            @CacheEvict(value = "categories", key = "'CACHE_KEY_CATEGORIES'", beforeInvocation = true),
            @CacheEvict(value = "category-display", key = "'CACHE_KEY_CATEGORIES_DISPLAY'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "category", key = "#category.categoryId")
        }
    )
    @Override
    public Category save(Category category) {
        if (category.getCategoryId() == null) {
            category.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            category.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return categoryRepository.save(category);
    }

    /**
     * Remove Category by id
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "categories", key = "'CACHE_KEY_CATEGORIES'"),
            @CacheEvict(value = "category-display", key = "'CACHE_KEY_CATEGORIES_DISPLAY'"),
            @CacheEvict(value = "category", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Get Category by name
     * @param name
     * @return Category
     */
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    /**
     * Get list category
     * @return List Category
     */
    @Cacheable(value = "category-display", key = "'CACHE_KEY_CATEGORIES_DISPLAY'", sync = true)
    @Override
    public List<Category> getCategoryDisplay() {
        return categoryRepository.getCategoryDisplay(CommonConst.DISPLAY_TRUE);
    }
}
