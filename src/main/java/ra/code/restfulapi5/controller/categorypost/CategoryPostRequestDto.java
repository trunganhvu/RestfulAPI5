package ra.code.restfulapi5.controller.categorypost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Getter
@Setter
public class CategoryPostRequestDto {
    @NotNull
    @JsonProperty("categoryId")
    private int categoryId;

    @NotNull
    @JsonProperty("categoryPostTitle")
    private String categoryPostTitle;

    @NotNull
    @JsonProperty("categoryPostContent")
    private String categoryPostContent;

    @NotNull
    @JsonProperty("categoryPostDescription")
    private String categoryPostDescription;

    @NotNull
    @JsonProperty("categoryPostUrl")
    private String categoryPostUrl;

    @NotNull
    @JsonProperty("categoryPostImage")
    private String categoryPostImage;

    @NotNull
    @JsonProperty("display")
    private boolean display;

    @NotNull
    @JsonProperty("displayOrder")
    private int displayOrder;

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
