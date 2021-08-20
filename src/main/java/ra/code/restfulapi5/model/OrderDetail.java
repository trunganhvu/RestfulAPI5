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
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id", nullable = false)
    private Long orderDetailId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "orderId", referencedColumnName = "order_id", nullable = false)
    private OrderCustomer orderCustomerId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productDetailId", referencedColumnName = "product_detail_id", nullable = false)
    private ProductDetail productDetailId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
