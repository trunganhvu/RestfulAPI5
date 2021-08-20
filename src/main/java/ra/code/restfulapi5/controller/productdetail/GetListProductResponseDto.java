package ra.code.restfulapi5.controller.productdetail;

import ra.code.restfulapi5.controller.productimage.ProductImageResponseDto;
import ra.code.restfulapi5.controller.productpromotion.ProductPromotionResponseDto;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/20
 */
public class GetListProductResponseDto {
    private Long productId;

    private String productCode;

    private String productName;

    private String productDescription;

    private Long productTypeId;

    private Long productPublicPrice;

    private int numberOfProduct;

    private List<ProductImageResponseDto> productImages;

    private List<ProductPromotionResponseDto> productPromotions;

    public GetListProductResponseDto() {
    }

    public GetListProductResponseDto(Long productId, String productCode, String productName, String productDescription, Long productTypeId, Long productPublicPrice, int numberOfProduct, List<ProductImageResponseDto> productImages, List<ProductPromotionResponseDto> productPromotions) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productTypeId = productTypeId;
        this.productPublicPrice = productPublicPrice;
        this.numberOfProduct = numberOfProduct;
        this.productImages = productImages;
        this.productPromotions = productPromotions;
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

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public List<ProductImageResponseDto> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImageResponseDto> productImages) {
        this.productImages = productImages;
    }

    public List<ProductPromotionResponseDto> getProductPromotions() {
        return productPromotions;
    }

    public void setProductPromotions(List<ProductPromotionResponseDto> productPromotions) {
        this.productPromotions = productPromotions;
    }
}
