package ra.code.restfulapi5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/13
 */
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", length = 50, nullable = false)
    private Long categoryId;

    @Column(name = "category_url", length = 50, nullable = false)
    private String categoryUrl;

    @Column(name = "category_name", length = 50, nullable = false)
    private String categoryName;

    @Column(name = "category_image_default", length = 255, nullable = false)
    private String categoryImageDefault;

    @Column(name = "category_image_default_name", length = 255, nullable = false)
    private String categoryImageDefaultName;

    @Column(name = "category_image_event", length = 255, nullable = true)
    private String categoryImageEvent;

    @Column(name = "category_image_event_name", length = 255, nullable = true)
    private String categoryImageEventName;

    @Column(name = "category_image_event_start", nullable = true)
    private Date categoryImageEventStart;

    @Column(name = "category_image_event_end", nullable = true)
    private Date categoryImageEventEnd;

    @Column(name = "display", nullable = false)
    private boolean display;

    @Column(name = "display_order", nullable = false)
    private int displayOrder;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
