package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/18
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_code", length = 255, nullable = false)
    private String productCode;

    @Column(name = "product_name", length = 255, nullable = false)
    private String productName;

    @Column(name = "product_description", length = 1000, nullable = false)
    private String productDescription;

    @Column(name = "product_detail", length = 1000, nullable = false)
    private String productDetail;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "productTypeId", referencedColumnName = "product_type_id", nullable = false)
    private ProductType productTypeId;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
