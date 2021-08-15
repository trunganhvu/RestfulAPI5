package ra.code.restfulapi5.controller.producttype;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class ProductTypeResponseDto {
    private Long productTypeId;

    private String productTypeCode;

    private String productTypeName;

    private String productTypeDescription;

    public ProductTypeResponseDto() {
    }

    public ProductTypeResponseDto(Long productTypeId, String productTypeCode, String productTypeName, String productTypeDescription) {
        this.productTypeId = productTypeId;
        this.productTypeCode = productTypeCode;
        this.productTypeName = productTypeName;
        this.productTypeDescription = productTypeDescription;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeCode() {
        return productTypeCode;
    }

    public void setProductTypeCode(String productTypeCode) {
        this.productTypeCode = productTypeCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }
}
