package ra.code.restfulapi5.controller.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author trunganhvu
 * 2021/08/18
 */
@Getter
@Setter
public class ProductRequestDto {
    @NotNull
    @JsonProperty("productCode")
    private String productCode;

    @NotNull
    @JsonProperty("productName")
    private String productName;

    @NotNull
    @JsonProperty("productDescription")
    private String productDescription;

    @NotNull
    @JsonProperty("productDetail")
    private String productDetail;

    @NotNull
    @JsonProperty("productTypeId")
    private Long productTypeId;
}
