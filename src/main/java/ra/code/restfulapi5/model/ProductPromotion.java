package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/19
 */
@Entity
@Data
public class ProductPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_promotion_id", nullable = false)
    private Long productPromotionId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productId", referencedColumnName = "product_id", nullable = false)
    private Product productId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "eventId", referencedColumnName = "event_id", nullable = true)
    private Event eventId;

    @Column(name = "discount", nullable = false)
    private int discount;

    @Column(name = "product_promotion_start", nullable = false)
    private Date productPromotionStart;

    @Column(name = "product_promotion_end", nullable = false)
    private Date productPromotionEnd;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
