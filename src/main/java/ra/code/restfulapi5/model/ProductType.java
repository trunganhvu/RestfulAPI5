package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Entity
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", nullable = false)
    private Long productTypeId;

    @Column(name = "product_type_code", length = 20, nullable = false)
    private String productTypeCode;

    @Column(name = "product_type_name", length = 255, nullable = false)
    private String productTypeName;

    @Column(name = "product_type_description", length = 255, nullable = false)
    private String productTypeDescription;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
