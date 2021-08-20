package ra.code.restfulapi5.controller.productimage;

import ra.code.restfulapi5.model.Product;

/**
 * @author trunganhvu
 * 2021/08/20
 */
public class ProductImageResponseDto {
    private Long productImageId;

    private String productImageName;

    private String productImagePath;

    public ProductImageResponseDto() {
    }

    public ProductImageResponseDto(Long productImageId, String productImageName, String productImagePath) {
        this.productImageId = productImageId;
        this.productImageName = productImageName;
        this.productImagePath = productImagePath;
    }

    public Long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Long productImageId) {
        this.productImageId = productImageId;
    }

    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }
}

