package ra.code.restfulapi5.controller.productcolor;

/**
 * @author trunganhvu
 * 2021/08/16
 */
public class ProductColorResponseDto {
    private Long productColorId;

    private String productColorCode;

    private String productColorName;

    public ProductColorResponseDto() {
    }

    public ProductColorResponseDto(Long productColorId, String productColorCode, String productColorName) {
        this.productColorId = productColorId;
        this.productColorCode = productColorCode;
        this.productColorName = productColorName;
    }

    public Long getProductColorId() {
        return productColorId;
    }

    public void setProductColorId(Long productColorId) {
        this.productColorId = productColorId;
    }

    public String getProductColorCode() {
        return productColorCode;
    }

    public void setProductColorCode(String productColorCode) {
        this.productColorCode = productColorCode;
    }

    public String getProductColorName() {
        return productColorName;
    }

    public void setProductColorName(String productColorName) {
        this.productColorName = productColorName;
    }
}
