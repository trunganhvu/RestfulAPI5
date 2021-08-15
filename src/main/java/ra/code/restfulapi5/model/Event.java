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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "event_name", length = 255, nullable = false)
    private String eventName;

    @Column(name = "event_slogun", length = 255, nullable = false)
    private String eventSlogun;

    @Column(name = "event_description", length = 500, nullable = true)
    private String eventDescription;

    @Column(name = "event_note", length = 500, nullable = true)
    private String eventNote;

    @Column(name = "event_image_banner", length = 255, nullable = true)
    private String eventImageBanner;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "event_start", nullable = false)
    private Date eventStart;

    @Column(name = "event_end", nullable = false)
    private Date eventEnd;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
