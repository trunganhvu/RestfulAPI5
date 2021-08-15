package ra.code.restfulapi5.controller.producttype;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Getter
@Setter
public class ProductTypeRequestDto {
    @NotNull
    @JsonProperty("productTypeCode")
    private String productTypeCode;

    @NotNull
    @JsonProperty("productTypeName")
    private String productTypeName;

    @NotNull
    @JsonProperty("productTypeDescription")
    private String productTypeDescription;
}
