package ra.code.restfulapi5.controller.productpromotion;

import ra.code.restfulapi5.model.Event;

import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/20
 */
public class ProductPromotionResponseDto {
    private Long productPromotionId;

    private Event eventId;

    private int discount;

    private Date productPromotionStart;

    private Date productPromotionEnd;

    public ProductPromotionResponseDto() {
    }

    public ProductPromotionResponseDto(Long productPromotionId, Event eventId, int discount, Date productPromotionStart, Date productPromotionEnd) {
        this.productPromotionId = productPromotionId;
        this.eventId = eventId;
        this.discount = discount;
        this.productPromotionStart = productPromotionStart;
        this.productPromotionEnd = productPromotionEnd;
    }

    public Long getProductPromotionId() {
        return productPromotionId;
    }

    public void setProductPromotionId(Long productPromotionId) {
        this.productPromotionId = productPromotionId;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getProductPromotionStart() {
        return productPromotionStart;
    }

    public void setProductPromotionStart(Date productPromotionStart) {
        this.productPromotionStart = productPromotionStart;
    }

    public Date getProductPromotionEnd() {
        return productPromotionEnd;
    }

    public void setProductPromotionEnd(Date productPromotionEnd) {
        this.productPromotionEnd = productPromotionEnd;
    }
}
