package ra.code.restfulapi5.service.orderdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.model.OrderDetail;
import ra.code.restfulapi5.repository.IOrderDetailRepository;

import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/20
 */
@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    /**
     * Get all order detail
     * @return List OrderDetail
     */
    @Cacheable(value = "orderdetails", key = "'CACHE_KEY_ORDER_DETAILS'", sync = true)
    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    /**
     * Get OrderDetail
     * @param id
     * @return OrderDetail
     */
    @Cacheable(value = "orderdetail", key = "#id", sync = true)
    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    /**
     * Save OrderDetail
     * @param orderDetail
     * @return OrderDetail
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "orderdetails", key = "'CACHE_KEY_ORDER_DETAILS'",  beforeInvocation = true)
            },
            put = {
                    @CachePut(value = "orderdetail", key = "#orderDetail.orderDetailId")
            }
    )
    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        if (orderDetail.getOrderDetailId() == null) {
            orderDetail.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            orderDetail.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return orderDetailRepository.save(orderDetail);
    }

    /**
     * Delete OrderDetail
     * @param id
     */
    @Caching(evict = {
            @CacheEvict(value = "orderdetails", key = "'CACHE_KEY_ORDER_DETAILS'"),
            @CacheEvict(value = "orderdetail", key = "#id")
    })
    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
