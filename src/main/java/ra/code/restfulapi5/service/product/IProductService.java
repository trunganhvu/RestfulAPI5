package ra.code.restfulapi5.service.product;

import ra.code.restfulapi5.model.Product;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/18
 */
public interface IProductService extends IGeneralService<Product> {

    /**
     * Get all product in product type
     * @param productTypeId
     * @return List Product
     */
    public List<Product> getAllProductInProductType(Long productTypeId);
}
