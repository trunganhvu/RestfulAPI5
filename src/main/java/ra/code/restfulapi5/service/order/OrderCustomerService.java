package ra.code.restfulapi5.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.OrderCustomer;
import ra.code.restfulapi5.repository.IOrderRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/20
 */
@Service
public class OrderCustomerService implements IOrderCustomerService {

    @Autowired
    private IOrderRepository orderRepository;

    /**
     * Find all order
     * @return List Order
     */
    @Cacheable(value = "orders", key = "'CACHE_KEY_ORDERS'", sync = true)
    @Override
    public Iterable<OrderCustomer> findAll() {
        return orderRepository.findAll();
    }

    /**
     * Find order by id
     * @param id
     * @return Order
     */
    @Cacheable(value = "order", key = "#id", sync = true)
    @Override
    public Optional<OrderCustomer> findById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Save order
     * @param orderCustomer
     * @return Order
     */
    @Caching(
        evict = {
            @CacheEvict(value = "orders", key = "'CACHE_KEY_ORDERS'",  beforeInvocation = true)
        },
        put = {
            @CachePut(value = "order", key = "#orderCustomer.orderId")
        }
    )
    @Override
    public OrderCustomer save(OrderCustomer orderCustomer) {
        if (orderCustomer.getOrderId() == null) {
            orderCustomer.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            orderCustomer.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return orderRepository.save(orderCustomer);
    }

    /**
     * Delete order by id
     * @param id
     */
    @Caching(evict = {
        @CacheEvict(value = "orders", key = "'CACHE_KEY_ORDERS'"),
        @CacheEvict(value = "order", key = "#id")
    })
    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);
    }
}
