package ra.code.restfulapi5.controller.category;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.common.util.Validator;
import ra.code.restfulapi5.controller.categorypost.CategoryConversion;
import ra.code.restfulapi5.controller.categorypost.CategoryPostResponseDto;
import ra.code.restfulapi5.model.Category;
import ra.code.restfulapi5.model.CategoryPost;
import ra.code.restfulapi5.service.category.ICategoryService;
import ra.code.restfulapi5.service.categorypost.ICategoryPostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICategoryPostService categoryPostService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all category
     * @return list CategoryResponseDto - 200 - OK
     */
    @GetMapping
    public ResponseEntity<Iterable<CategoryResponseDto>> getAllCategory() {
        // Get list from server
        List<Category> categoryList = new ArrayList<Category>();
        categoryService.findAll().forEach(categoryList::add);

        // Set result to dto
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryList.forEach(category -> {
            categoryResponseDtoList.add(convertCategoryToCategoryResponseDto(category));
        });
        return new ResponseEntity<>(categoryResponseDtoList, HttpStatus.OK);
    }

    /**
     * Get detail category by id
     * @param id
     * @return CategoryResponseDto - 200 - OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long id) {
        // Get category from service
        Optional<Category> categoryOptional = categoryService.findById(id);

        return categoryOptional
                .map(category -> new ResponseEntity<>(convertCategoryToCategoryResponseDto(category), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get list post in category by categoryId
     * @param categoryId
     * @return list post - 200 - OK
     */
    @GetMapping("/{categoryId}/post")
    public ResponseEntity<Iterable<CategoryPostResponseDto>> getAllCategoryPostById(@PathVariable Long categoryId) {
        List<CategoryPost> categoryPostList = new ArrayList<>();
        categoryPostService.getListCategoryPostById(categoryId).forEach(categoryPostList::add);

        List<CategoryPostResponseDto> categoryPostResponseDtoList = new ArrayList<>();
        categoryPostList.forEach(post -> {
            categoryPostResponseDtoList.add(CategoryConversion.convertCategoryPostToCategoryPostResponseDto(post));
        });
        return new ResponseEntity<>(categoryPostResponseDtoList, HttpStatus.OK);
    }

    /**
     * Get list category display
     * @return list category
     */
    @GetMapping("/display")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategoryDisplay() {
        // Get list category display
        List<Category> categoryList = categoryService.getCategoryDisplay();

        // Map list category to dto
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryList.forEach(category -> {
            categoryResponseDtoList.add(convertCategoryToCategoryResponseDto(category));
        });
        return new ResponseEntity<>(categoryResponseDtoList, HttpStatus.OK);
    }

    /**
     * Get all category post display in category
     * @param id
     * @return List CategoryPostResponseDto
     */
    @GetMapping("/{id}/display")
    public ResponseEntity<List<CategoryPostResponseDto>> getCategoryPostDisplayInCategory(@PathVariable Long id) {
        // Get list category post display in category
        List<CategoryPost> categoryPostList = categoryPostService.getListCategoryPostDisplayInCategory(id);

        // Map category post to Dto
        List<CategoryPostResponseDto> categoryPostResponseDtoList = new ArrayList<>();
        categoryPostList.forEach(post -> {
            categoryPostResponseDtoList.add(CategoryConversion.convertCategoryPostToCategoryPostResponseDto(post));
        });
        return new ResponseEntity<>(categoryPostResponseDtoList, HttpStatus.OK);
    }

    /**
     * Create new category
     * @param categoryRequestDto
     * @return Category last created - 200 - OK
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        // Validate start <= end
        if (!Validator.startIsLQEnd(categoryRequestDto.getCategoryImageEventStart(),
                categoryRequestDto.getCategoryImageEventEnd())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Map dto to category
        Category category = convertCategoryRequestDtoToCategory(categoryRequestDto);

        // save()
        return new ResponseEntity<>(
                convertCategoryToCategoryResponseDto(categoryService.save(category)),
                HttpStatus.OK
        );
    }

    /**
     * Update category by id
     * @param id
     * @param categoryRequestDto
     * @return category last updated - 200 - OK
     */
    @PostMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id,
                                                              @RequestBody CategoryRequestDto categoryRequestDto) {
        // Validate start <= end
        if (!Validator.startIsLQEnd(categoryRequestDto.getCategoryImageEventStart(),
                categoryRequestDto.getCategoryImageEventEnd())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Find category by id
        Optional<Category> categoryOptional = categoryService.findById(id);

        // Convert request dto to category
        Category category = convertCategoryRequestDtoToCategory(categoryRequestDto);

        return categoryOptional.map(category1 -> {
            category.setCategoryId(category1.getCategoryId());
            category.setCreatedAt(category1.getCreatedAt());
            return new ResponseEntity<>(
                    convertCategoryToCategoryResponseDto(categoryService.save(category)),
                    HttpStatus.OK
            );
        }). orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete category by id
     * @param id
     * @return category - 200 - success: true - OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCategoryResponseDto> deleteCategory(@PathVariable Long id) {
        // Find category by id
        Optional<Category> categoryOptional = categoryService.findById(id);

        // Remove and return result
        DeleteCategoryResponseDto result = new DeleteCategoryResponseDto(true);
        return categoryOptional.map(category -> {
            categoryService.remove(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert CategoryRequestDto to Category(Entity)
     * @param categoryRequestDto
     * @return Category
     */
    private Category convertCategoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto) {
        Category category = modelMapper.map(categoryRequestDto, Category.class);
        category.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        return category;
    }

    /**
     * Convert Category to Category Response Dto
     * @param category
     * @return Category Response Dto
     */
    private CategoryResponseDto convertCategoryToCategoryResponseDto(Category category) {
        CategoryResponseDto categoryResponseDto = modelMapper.map(category, CategoryResponseDto.class);
        return categoryResponseDto;
    }
}
