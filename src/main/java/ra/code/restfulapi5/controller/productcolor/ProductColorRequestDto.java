package ra.code.restfulapi5.controller.productcolor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Getter
@Setter
public class ProductColorRequestDto {
    @NotNull
    @JsonProperty("productColorCode")
    private String productColorCode;

    @NotNull
    @JsonProperty("productColorName")
    private String productColorName;
}
