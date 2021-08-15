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
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image_default_path", length = 255, nullable = false)
    private String imageDefaultPath;

    @Column(name = "image_default_name", length = 255, nullable = false)
    private String imageDefaultName;

    @Column(name = "image_event_path", length = 255, nullable = true)
    private String imageEventPath;

    @Column(name = "image_event_name", length = 255, nullable = true)
    private String imageEventName;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
