package ra.code.restfulapi5.controller.productsize;

import ra.code.restfulapi5.model.ProductType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author trunganhvu
 * 2021/08/16
 */
public class ProductSizeResponseDto {
    private Long productSizeId;

    private String productSizeCode;

    private String productSizeName;

    private Long productTypeId;

    private int productSizeWidthMin;

    private int productSizeWidthMax;

    private int productSizeHeightMin;

    private int productSizeHeightMax;

    public ProductSizeResponseDto() {
    }

    public ProductSizeResponseDto(Long productSizeId, String productSizeCode, String productSizeName, Long productTypeId, int productSizeWidthMin, int productSizeWidthMax, int productSizeHeightMin, int productSizeHeightMax) {
        this.productSizeId = productSizeId;
        this.productSizeCode = productSizeCode;
        this.productSizeName = productSizeName;
        this.productTypeId = productTypeId;
        this.productSizeWidthMin = productSizeWidthMin;
        this.productSizeWidthMax = productSizeWidthMax;
        this.productSizeHeightMin = productSizeHeightMin;
        this.productSizeHeightMax = productSizeHeightMax;
    }

    public Long getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(Long productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getProductSizeCode() {
        return productSizeCode;
    }

    public void setProductSizeCode(String productSizeCode) {
        this.productSizeCode = productSizeCode;
    }

    public String getProductSizeName() {
        return productSizeName;
    }

    public void setProductSizeName(String productSizeName) {
        this.productSizeName = productSizeName;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getProductSizeWidthMin() {
        return productSizeWidthMin;
    }

    public void setProductSizeWidthMin(int productSizeWidthMin) {
        this.productSizeWidthMin = productSizeWidthMin;
    }

    public int getProductSizeWidthMax() {
        return productSizeWidthMax;
    }

    public void setProductSizeWidthMax(int productSizeWidthMax) {
        this.productSizeWidthMax = productSizeWidthMax;
    }

    public int getProductSizeHeightMin() {
        return productSizeHeightMin;
    }

    public void setProductSizeHeightMin(int productSizeHeightMin) {
        this.productSizeHeightMin = productSizeHeightMin;
    }

    public int getProductSizeHeightMax() {
        return productSizeHeightMax;
    }

    public void setProductSizeHeightMax(int productSizeHeightMax) {
        this.productSizeHeightMax = productSizeHeightMax;
    }
}
