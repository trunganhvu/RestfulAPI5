package ra.code.restfulapi5.controller.category;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Category Response Dto
 * @author trunganhvu
 * 2021/08/13
 */
public class CategoryResponseDto {
    private Long categoryId;

    private String categoryUrl;

    private String categoryName;

    private String categoryImageDefault;

    private String categoryImageDefaultName;

    private String categoryImageEvent;

    private String categoryImageEventName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date categoryImageEventStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date categoryImageEventEnd;

    private boolean display;

    private int displayOrder;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageDefault() {
        return categoryImageDefault;
    }

    public void setCategoryImageDefault(String categoryImageDefault) {
        this.categoryImageDefault = categoryImageDefault;
    }

    public String getCategoryImageDefaultName() {
        return categoryImageDefaultName;
    }

    public void setCategoryImageDefaultName(String categoryImageDefaultName) {
        this.categoryImageDefaultName = categoryImageDefaultName;
    }

    public String getCategoryImageEvent() {
        return categoryImageEvent;
    }

    public void setCategoryImageEvent(String categoryImageEvent) {
        this.categoryImageEvent = categoryImageEvent;
    }

    public String getCategoryImageEventName() {
        return categoryImageEventName;
    }

    public void setCategoryImageEventName(String categoryImageEventName) {
        this.categoryImageEventName = categoryImageEventName;
    }

    public Date getCategoryImageEventStart() {
        return categoryImageEventStart;
    }

    public void setCategoryImageEventStart(Date categoryImageEventStart) {
        this.categoryImageEventStart = categoryImageEventStart;
    }

    public Date getCategoryImageEventEnd() {
        return categoryImageEventEnd;
    }

    public void setCategoryImageEventEnd(Date categoryImageEventEnd) {
        this.categoryImageEventEnd = categoryImageEventEnd;
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
