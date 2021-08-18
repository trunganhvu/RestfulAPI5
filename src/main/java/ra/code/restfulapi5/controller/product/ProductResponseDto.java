package ra.code.restfulapi5.controller.product;

/**
 * @author trunganhvu
 * 2021/08/18
 */
public class ProductResponseDto {
    private Long productId;

    private String productCode;

    private String productName;

    private String productDescription;

    private String productDetail;

    private Long productTypeId;

    public ProductResponseDto() {
    }

    public ProductResponseDto(Long productId, String productCode, String productName, String productDescription, String productDetail, Long productTypeId) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productDetail = productDetail;
        this.productTypeId = productTypeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }
}
