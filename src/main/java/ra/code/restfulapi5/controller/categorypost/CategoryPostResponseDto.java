package ra.code.restfulapi5.controller.categorypost;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public class CategoryPostResponseDto {
    private Long categoryPostId;

    private int categoryId;

    private String categoryPostTitle;

    private String categoryPostContent;

    private String categoryPostDescription;

    private String categoryPostUrl;

    private String categoryPostImage;

    private boolean display;

    private int displayOrder;

    public CategoryPostResponseDto(Long categoryPostId, int categoryId, String categoryPostTitle,
                                   String categoryPostContent, String categoryPostDescription,
                                   String categoryPostUrl, String categoryPostImage, boolean display, int displayOrder) {
        this.categoryPostId = categoryPostId;
        this.categoryId = categoryId;
        this.categoryPostTitle = categoryPostTitle;
        this.categoryPostContent = categoryPostContent;
        this.categoryPostDescription = categoryPostDescription;
        this.categoryPostUrl = categoryPostUrl;
        this.categoryPostImage = categoryPostImage;
        this.display = display;
        this.displayOrder = displayOrder;
    }

    public Long getCategoryPostId() {
        return categoryPostId;
    }

    public void setCategoryPostId(Long categoryPostId) {
        this.categoryPostId = categoryPostId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryPostTitle() {
        return categoryPostTitle;
    }

    public void setCategoryPostTitle(String categoryPostTitle) {
        this.categoryPostTitle = categoryPostTitle;
    }

    public String getCategoryPostContent() {
        return categoryPostContent;
    }

    public void setCategoryPostContent(String categoryPostContent) {
        this.categoryPostContent = categoryPostContent;
    }

    public String getCategoryPostDescription() {
        return categoryPostDescription;
    }

    public void setCategoryPostDescription(String categoryPostDescription) {
        this.categoryPostDescription = categoryPostDescription;
    }

    public String getCategoryPostUrl() {
        return categoryPostUrl;
    }

    public void setCategoryPostUrl(String categoryPostUrl) {
        this.categoryPostUrl = categoryPostUrl;
    }

    public String getCategoryPostImage() {
        return categoryPostImage;
    }

    public void setCategoryPostImage(String categoryPostImage) {
        this.categoryPostImage = categoryPostImage;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
}
