package ra.code.restfulapi5.controller.productsize;

import ra.code.restfulapi5.model.ProductSize;

/**
 * @author trunganhvu
 * 2021/08/17
 */
public class ProductSizeConversion {
    /**
     * Convert ProductSize to ProductSizeResponseDto
     * @param productSize
     * @return ProductSizeResponseDto
     */
    public static ProductSizeResponseDto convertProductSizeToProductSizeResponseDto(ProductSize productSize) {
        ProductSizeResponseDto productSizeResponseDto = new ProductSizeResponseDto();
        productSizeResponseDto.setProductSizeId(productSize.getProductSizeId());
        productSizeResponseDto.setProductSizeCode(productSize.getProductSizeCode());
        productSizeResponseDto.setProductSizeName(productSize.getProductSizeName());
        productSizeResponseDto.setProductSizeWidthMin(productSize.getProductSizeWidthMin());
        productSizeResponseDto.setProductSizeWidthMax(productSize.getProductSizeWidthMax());
        productSizeResponseDto.setProductSizeHeightMin(productSize.getProductSizeHeightMin());
        productSizeResponseDto.setProductSizeHeightMax(productSize.getProductSizeHeightMax());
        productSizeResponseDto.setProductTypeId(productSize.getProductTypeId().getProductTypeId());
        return productSizeResponseDto;
    }
}
