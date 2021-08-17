package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/16
 */
@Entity
@Data
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_size_id", nullable = false)
    private Long productSizeId;

    @Column(name = "product_size_code", length = 25, nullable = false)
    private String productSizeCode;

    @Column(name = "product_size_name", length = 255, nullable = false)
    private String productSizeName;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productTypeId", referencedColumnName = "product_type_id", nullable = false)
    private ProductType productTypeId;

    @Column(name = "product_size_width_min", nullable = true)
    private int productSizeWidthMin;

    @Column(name = "product_size_width_max", nullable = true)
    private int productSizeWidthMax;

    @Column(name = "product_size_height_min", nullable = true)
    private int productSizeHeightMin;

    @Column(name = "product_size_height_max", nullable = true)
    private int productSizeHeightMax;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
