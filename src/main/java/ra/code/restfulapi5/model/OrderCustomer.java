package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/20
 */
@Entity
@Data
public class OrderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "deliveryId", referencedColumnName = "delivery_id", nullable = false)
    private Delivery deliveryId;

    @Column(name = "order_code", length = 50, nullable = false)
    private String orderCode;

    @Column(name = "order_note", length = 255, nullable = false)
    private String orderNote;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "order_time", nullable = false)
    private Date orderTime;

    @Column(name = "confirm_order_status", nullable = false)
    private boolean confirmOrderStatus;

    @Column(name = "confirm_order_time", nullable = true)
    private Date confirmOrderTime;

    @Column(name = "delivery_status", nullable = false)
    private boolean deliveryStatus;

    @Column(name = "delivery_time", nullable = true)
    private Date deliveryTime;

    @Column(name = "delivery_customer_pay", nullable = false)
    private Long deliveryCustomerPay;

    @Column(name = "delivery_shop_pay", nullable = false)
    private Long deliveryShopPay;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
