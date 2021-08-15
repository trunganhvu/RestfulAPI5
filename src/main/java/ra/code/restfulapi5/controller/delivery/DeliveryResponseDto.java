package ra.code.restfulapi5.controller.delivery;

import java.math.BigDecimal;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class DeliveryResponseDto {
    private Long deliveryId;

    private String deliveryName;

    private String deliveryPhone;

    private BigDecimal deliveryPrice;

    private boolean isUsing;

    public DeliveryResponseDto() {
    }

    public DeliveryResponseDto(Long deliveryId, String deliveryName, String deliveryPhone, BigDecimal deliveryPrice, boolean isUsing) {
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
        this.deliveryPhone = deliveryPhone;
        this.deliveryPrice = deliveryPrice;
        this.isUsing = isUsing;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }
}
