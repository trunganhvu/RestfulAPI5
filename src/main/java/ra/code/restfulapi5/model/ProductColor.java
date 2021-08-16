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
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_color_id", nullable = false)
    private Long productColorId;

    @Column(name = "product_color_code", length = 50, nullable = false)
    private String productColorCode;

    @Column(name = "product_color_name", length = 255, nullable = false)
    private String productColorName;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
