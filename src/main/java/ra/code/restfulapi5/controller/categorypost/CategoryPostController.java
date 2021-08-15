package ra.code.restfulapi5.controller.categorypost;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.common.util.ConvertData;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.controller.category.CategoryRequestDto;
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
@RequestMapping("/api/v1/category-posts")
public class CategoryPostController {
    @Autowired
    private ICategoryPostService categoryPostService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all Category Post
     * @return List Category Post
     */
    @GetMapping
    public ResponseEntity<Iterable<CategoryPostResponseDto>> getAll() {
        // Get all category post
        List<CategoryPost> categoryPostList = new ArrayList<>();
        categoryPostService.findAll().forEach(categoryPostList::add);

        // Map category post to response dto
        List<CategoryPostResponseDto> categoryPostResponseDtoList = new ArrayList<>();
        categoryPostList.forEach(categoryPost -> {
            categoryPostResponseDtoList.add(
                    CategoryConversion.convertCategoryPostToCategoryPostResponseDto(categoryPost)
            );
        });
        return new ResponseEntity<>(categoryPostResponseDtoList, HttpStatus.OK);
    }

    /**
     * Get Category Post by id
     * @param id
     * @return Category Post
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryPostResponseDto> getCategoryPost(@PathVariable Long id) {
        Optional<CategoryPost> categoryPostOptional = categoryPostService.findById(id);
        return categoryPostOptional.map(
                categoryPost -> new ResponseEntity<>(
                        CategoryConversion.convertCategoryPostToCategoryPostResponseDto(categoryPost),
                        HttpStatus.OK
                ))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     *
     * @return
     */
    @GetMapping("/display")
    public ResponseEntity<List<CategoryPostResponseDto>> getAllCategoryPostDisplay() {
        // Get list category post display in category
        List<CategoryPost> categoryPostList = categoryPostService.getListCategoryPostDisplay();

        // Map category post to Dto
        List<CategoryPostResponseDto> categoryPostResponseDtoList = new ArrayList<>();
        categoryPostList.forEach(post -> {
            categoryPostResponseDtoList.add(CategoryConversion.convertCategoryPostToCategoryPostResponseDto(post));
        });
        return new ResponseEntity<>(categoryPostResponseDtoList, HttpStatus.OK);
    }

    /**
     * Create Category Post
     * @param categoryPostRequestDto
     * @return Category Post
     */
    @PostMapping
    public ResponseEntity<CategoryPostResponseDto> createCategoryPost(@RequestBody CategoryPostRequestDto categoryPostRequestDto) {
        // Find category by id
        Optional<Category> category = categoryService.findById(
                ConvertData.convertToLong(categoryPostRequestDto.getCategoryId())
        );

        CategoryPost categoryPost = categoryPostService.save(
                convertCategoryPostRequestDtoToCategoryPost(categoryPostRequestDto, category.get()));
        return new ResponseEntity<>(
                CategoryConversion.convertCategoryPostToCategoryPostResponseDto(categoryPost),
                HttpStatus.OK
        );
    }

    /**
     * Update Category Post
     * @param id
     * @param categoryPostRequestDto
     * @return CategoryPostResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<CategoryPostResponseDto> updateCategoryPost(
            @PathVariable Long id,
            @RequestBody CategoryPostRequestDto categoryPostRequestDto) {
        // Find post by id
        Optional<CategoryPost> categoryPostOptional = categoryPostService.findById(id);

        // Get Category by id
        Optional<Category> categoryOptional = categoryService.findById(
                ConvertData.convertToLong(categoryPostRequestDto.getCategoryId())
        );
        Category category = categoryOptional.get();

        // Map request dto to entity
        CategoryPost categoryPost = convertCategoryPostRequestDtoToCategoryPost(
                categoryPostRequestDto, category
        );

        // Save post
        return categoryPostOptional.map(post -> {
            categoryPost.setCategoryPostId(post.getCategoryPostId());
            categoryPost.setCategoryId(category);
            categoryPost.setCreatedAt(post.getCreatedAt());
            return new ResponseEntity<>(
                    CategoryConversion.convertCategoryPostToCategoryPostResponseDto(
                            categoryPostService.save(categoryPost)
                    ),
                    HttpStatus.OK
            );
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    /**
     * Delete Category Post
     * @param id
     * @return DeleteCategoryPostResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCategoryPostResponseDto> deleteCategoryPost(@PathVariable Long id) {
        // Find category post by id
        Optional<CategoryPost> categoryPostOptional = categoryPostService.findById(id);

        // Remove and return result
        DeleteCategoryPostResponseDto result = new DeleteCategoryPostResponseDto(true);
        return categoryPostOptional.map(categoryPost -> {
            categoryPostService.remove(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /**
     * Convert Category Post Request dto to Category Post
     * @param categoryPostRequestDto
     * @param category
     * @return CategoryPost
     */
    private CategoryPost convertCategoryPostRequestDtoToCategoryPost(
            CategoryPostRequestDto categoryPostRequestDto,
            Category category) {
        CategoryPost categoryPost = modelMapper.map(categoryPostRequestDto, CategoryPost.class);
        categoryPost.setCategoryId(category);
        return  categoryPost;
    }


}
