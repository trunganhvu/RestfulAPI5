package ra.code.restfulapi5.controller.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Getter
@Setter
public class DeliveryRequestDto {

    @NotNull
    @JsonProperty("deliveryName")
    private String deliveryName;

    @JsonProperty("deliveryPhone")
    private String deliveryPhone;

    @NotNull
    @JsonProperty("deliveryPrice")
    private BigDecimal deliveryPrice;

    @NotNull
    @JsonProperty("isUsing")
    private boolean isUsing;
}
