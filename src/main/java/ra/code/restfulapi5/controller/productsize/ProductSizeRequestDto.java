package ra.code.restfulapi5.controller.productsize;

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
public class ProductSizeRequestDto {
    @NotNull
    @JsonProperty("productSizeCode")
    private String productSizeCode;

    @NotNull
    @JsonProperty("productSizeName")
    private String productSizeName;

    @NotNull
    @JsonProperty("productTypeId")
    private Long productTypeId;

    @JsonProperty("productSizeWidthMin")
    private int productSizeWidthMin;

    @JsonProperty("productSizeWidthMax")
    private int productSizeWidthMax;

    @JsonProperty("productSizeHeightMin")
    private int productSizeHeightMin;

    @JsonProperty("productSizeHeightMax")
    private int productSizeHeightMax;
}
