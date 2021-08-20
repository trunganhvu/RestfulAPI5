package ra.code.restfulapi5.controller.productdetail;

import ra.code.restfulapi5.controller.productcolor.ProductColorResponseDto;
import ra.code.restfulapi5.controller.productimage.ProductImageResponseDto;
import ra.code.restfulapi5.controller.productpromotion.ProductPromotionResponseDto;
import ra.code.restfulapi5.controller.productsize.ProductSizeResponseDto;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/20
 */
public class GetProductDetailResponseDto {
    private Long productId;

    private String productCode;

    private String productName;

    private String productDescription;

    private Long productTypeId;

    private List<ProductImageResponseDto> productImages;

    private List<ProductPromotionResponseDto> productPromotions;

    private List<ProductColorResponseDto> productColors;

    private List<ProductSizeResponseDto> productSizes;

    private Long productPublicPrice;

    private int numberOfProduct;

    public GetProductDetailResponseDto() {
    }

    public GetProductDetailResponseDto(Long productId, String productCode, String productName, String productDescription, Long productTypeId, List<ProductImageResponseDto> productImages, List<ProductPromotionResponseDto> productPromotions, List<ProductColorResponseDto> productColors, List<ProductSizeResponseDto> productSizes, Long productPublicPrice, int numberOfProduct) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productTypeId = productTypeId;
        this.productImages = productImages;
        this.productPromotions = productPromotions;
        this.productColors = productColors;
        this.productSizes = productSizes;
        this.productPublicPrice = productPublicPrice;
        this.numberOfProduct = numberOfProduct;
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

    public List<ProductColorResponseDto> getProductColors() {
        return productColors;
    }

    public void setProductColors(List<ProductColorResponseDto> productColors) {
        this.productColors = productColors;
    }

    public List<ProductSizeResponseDto> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSizeResponseDto> productSizes) {
        this.productSizes = productSizes;
    }

    public Long getProductPublicPrice() {
        return productPublicPrice;
    }

    public void setProductPublicPrice(Long productPublicPrice) {
        this.productPublicPrice = productPublicPrice;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }
}
