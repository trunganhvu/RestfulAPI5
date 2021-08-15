package ra.code.restfulapi5.service.delivery;

import ra.code.restfulapi5.model.Delivery;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public interface IDeliveryService extends IGeneralService<Delivery> {

    /**
     * Get list delivery using
     * @return list delivery
     */
    public List<Delivery> getAllDeliveryUsing();
}
