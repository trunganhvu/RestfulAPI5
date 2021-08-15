package ra.code.restfulapi5.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.common.variableconst.CommonConst;
import ra.code.restfulapi5.model.Delivery;
import ra.code.restfulapi5.repository.IDeliveryRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Service
public class DeliveryService implements IDeliveryService{

    @Autowired
    private IDeliveryRepository deliveryRepository;

    /**
     * Get all delivery
     * @return List delivery
     */
    @Cacheable(value = "deliveries", key = "'CACHE_KEY_DELIVERY'", sync = true)
    @Override
    public Iterable<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    /**
     * Find delivery by id
     * @param id
     * @return delivery
     */
    @Cacheable(value = "delivery", key = "#id", sync = true)
    @Override
    public Optional<Delivery> findById(Long id) {
        return deliveryRepository.findById(id);
    }

    /**
     * Save delivery
     * @param delivery
     * @return Delivery
     */
    @Caching(
        evict = {
            @CacheEvict(value = "deliveries", key = "'CACHE_KEY_DELIVERY'",  beforeInvocation = true),
            @CacheEvict(value = "deliveries-using", key = "'CACHE_KEY_DELIVERY_USING'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "delivery", key = "#delivery.deliveryId")
        }
    )
    @Override
    public Delivery save(Delivery delivery) {
        if (delivery.getDeliveryId() == null) {
            delivery.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            delivery.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return deliveryRepository.save(delivery);
    }

    /**
     * Remove delivery by id
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "deliveries", key = "'CACHE_KEY_DELIVERY'"),
            @CacheEvict(value = "deliveries-using", key = "'CACHE_KEY_DELIVERY_USING'"),
            @CacheEvict(value = "delivery", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        deliveryRepository.deleteById(id);
    }

    /**
     * Get all delivery using
     * @return List delivery
     */
    @Cacheable(value = "deliveries-using", key = "'CACHE_KEY_DELIVERY_USING'", sync = true)
    @Override
    public List<Delivery> getAllDeliveryUsing() {
        return deliveryRepository.getAllDeliveryUsing(CommonConst.USING_TRUE);
    }
}
