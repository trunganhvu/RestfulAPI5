package ra.code.restfulapi5.service.productsize;

import ra.code.restfulapi5.model.ProductSize;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/16
 */
public interface IProductSizeService extends IGeneralService<ProductSize> {

    /**
     * Get all product size in product type
     * @param productTypeId
     * @return List ProductSize
     */
    public List<ProductSize> getProductSizeInProductType(Long productTypeId);
}
