package ra.code.restfulapi5.controller.categorypost;

import ra.code.restfulapi5.common.util.ConvertData;
import ra.code.restfulapi5.model.CategoryPost;

/**
 * @author trunganhvu
 * 2021/08/14
 */
public class CategoryConversion {
    /**
     * Convert Category to Category Post Response Dto
     * @param categoryPost
     * @return CategoryPostResponseDto
     */
    public static CategoryPostResponseDto convertCategoryPostToCategoryPostResponseDto(CategoryPost categoryPost) {
        // Map object
//        CategoryPostResponseDto categoryPostResponseDto = modelMapper.map(categoryPost, CategoryPostResponseDto.class);
        CategoryPostResponseDto categoryPostResponseDto = new CategoryPostResponseDto(categoryPost.getCategoryPostId(),
                ConvertData.convertToInt(categoryPost.getCategoryId().getCategoryId()), categoryPost.getCategoryPostTitle(),
                categoryPost.getCategoryPostContent(), categoryPost.getCategoryPostDescription(),
                categoryPost.getCategoryPostUrl(), categoryPost.getCategoryPostImage(),
                categoryPost.isDisplay(), categoryPost.getDisplayOrder());
        return categoryPostResponseDto;
    }
}
