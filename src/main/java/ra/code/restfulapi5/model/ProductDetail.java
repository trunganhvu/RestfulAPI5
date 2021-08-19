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
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id", nullable = false)
    private Long productDetailId;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productId", referencedColumnName = "product_id", nullable = false)
    private Product productId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productSizeId", referencedColumnName = "product_size_id", nullable = false)
    private ProductSize productSizeId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productColorId", referencedColumnName = "product_color_id", nullable = false)
    private ProductColor productColorId;

    @Column(name = "product_original_price", nullable = false)
    private Long productOriginalPrice;

    @Column(name = "product_public_price", nullable = false)
    private Long productPublicPrice;

    @Column(name = "number_of_product", nullable = false)
    private int numberOfProduct;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
