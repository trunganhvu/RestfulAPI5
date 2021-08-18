package ra.code.restfulapi5.controller.product;

import ra.code.restfulapi5.model.Product;

/**
 * @author trunganhvu
 * 2021/08/18
 */
public class ProductConversion {

    /**
     * Convert Product to ProductResponseDto
     * @param product
     * @return ProductResponseDto
     */
    public static ProductResponseDto convertProductToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setProductCode(product.getProductCode());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setProductDetail(product.getProductDetail());
        productResponseDto.setProductDescription(product.getProductDescription());
        productResponseDto.setProductTypeId(product.getProductTypeId().getProductTypeId());
        return productResponseDto;
    }
}
