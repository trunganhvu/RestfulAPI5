package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id", nullable = false)
    private Long deliveryId;

    @Column(name = "delivery_name", length = 255, nullable = false, unique = true)
    private String deliveryName;

    @Column(name = "delivery_phone", length = 255, nullable = true)
    private String deliveryPhone;

    @Column(name = "delivery_price", nullable = false)
    private BigDecimal deliveryPrice;

    @Column(name = "is_using", nullable = false)
    private boolean isUsing;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
