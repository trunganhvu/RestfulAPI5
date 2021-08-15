package ra.code.restfulapi5.service.categorypost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.common.variableconst.CommonConst;
import ra.code.restfulapi5.model.CategoryPost;
import ra.code.restfulapi5.repository.ICategoryPostRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Service
public class CategoryPostService implements ICategoryPostService {
    @Autowired
    private ICategoryPostRepository categoryPostRepository;

    /**
     * Get all
     * @return list CategoryPost
     */
    @Cacheable(value = "categoryposts", key = "'CACHE_KEY_CATEGORYPOSTS'", sync = true)
    @Override
    public Iterable<CategoryPost> findAll() {
        return categoryPostRepository.findAll();
    }

    /**
     * Get by id
     * @param id
     * @return CategoryPost
     */
    @Cacheable(value = "categorypost", key = "#id", sync = true)
    @Override
    public Optional<CategoryPost> findById(Long id) {
        return categoryPostRepository.findById(id);
    }

    /**
     * Save CategoryPost
     * @param categoryPost
     * @return CategoryPost
     */
    @Caching(
        evict = {
            @CacheEvict(value = "categoryposts", key = "'CACHE_KEY_CATEGORYPOSTS'", beforeInvocation = true),
            @CacheEvict(value = "categorypost-display", key = "'CACHE_KEY_CATEGORYPOST_DISPLAY'", beforeInvocation = true),
            @CacheEvict(value = "categorypost-display-in-category", key = "#categoryPost.categoryId.categoryId", beforeInvocation = true),
            @CacheEvict(value = "categorypost-in-category", key = "#categoryPost.categoryId.categoryId", beforeInvocation = true)
        },
        put = {
            @CachePut(value = "categorypost", key = "#categoryPost.categoryPostId")
        }
    )
    @Override
    public CategoryPost save(CategoryPost categoryPost) {
        if (categoryPost.getCategoryPostId() == null) {
            categoryPost.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            categoryPost.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return categoryPostRepository.save(categoryPost);
    }

    /**
     * Remove CategoryPost by id
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "categoryposts", key = "'CACHE_KEY_CATEGORYPOSTS'"),
            @CacheEvict(value = "categorypost-display", key = "'CACHE_KEY_CATEGORYPOST_DISPLAY'"),
            @CacheEvict(value = "categorypost-display-in-category", key = "#id"),
            @CacheEvict(value = "categorypost-in-category", key = "#id"),
            @CacheEvict(value = "categorypost", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        categoryPostRepository.deleteById(id);
    }

    /**
     * Get list CategoryPost by Category id
     * @param id
     * @return List CategoryPost
     */
    @Cacheable(value = "categorypost-in-category", key = "#id", sync = true)
    @Override
    public List<CategoryPost> getListCategoryPostById(Long id) {
        return categoryPostRepository.getListCategoryPostById(id);
    }

    /**
     * Get list category post display in category id
     * @param id
     * @return list category post
     */
    @Cacheable(value = "categorypost-display-in-category", key = "#id", sync = true)
    @Override
    public List<CategoryPost> getListCategoryPostDisplayInCategory(Long id) {
        return categoryPostRepository.getListCategoryPostDisplayInCategory(id, CommonConst.DISPLAY_TRUE);
    }

    /**
     * Get list category post display
     * @return list category post
     */
    @Cacheable(value = "categorypost-display", key = "'CACHE_KEY_CATEGORYPOST_DISPLAY'", sync = true)
    @Override
    public List<CategoryPost> getListCategoryPostDisplay() {
        return categoryPostRepository.getListCategoryPostDisplay(CommonConst.DISPLAY_TRUE);
    }
}
