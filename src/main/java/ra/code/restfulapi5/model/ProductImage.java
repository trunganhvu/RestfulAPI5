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
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id", nullable = false)
    private Long productImageId;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productId", referencedColumnName = "product_id", nullable = false)
    private Product productId;

    @Column(name = "product_image_name", length = 255, nullable = false)
    private String productImageName;

    @Column(name = "product_image_path", length = 300, nullable = false)
    private String productImagePath;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
