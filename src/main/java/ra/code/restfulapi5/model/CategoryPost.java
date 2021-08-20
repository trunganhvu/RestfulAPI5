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
public class CategoryPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_post_id", nullable = false, unique = true)
    private Long categoryPostId;

//    @Column(name = "category_id", nullable = false)
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "categoryId", referencedColumnName = "category_id", nullable = false)
    private Category categoryId;

    @Column(name = "category_post_title", length = 255, nullable = false)
    private String categoryPostTitle;

    @Column(name = "category_post_content", length = 1000, nullable = true)
    private String categoryPostContent;

    @Column(name = "category_post_description", length = 400, nullable = true)
    private String categoryPostDescription;

    @Column(name = "category_post_url", length = 255, nullable = true)
    private String categoryPostUrl;

    @Column(name = "category_post_image", length = 255, nullable = true)
    private String categoryPostImage;

    @Column(name = "display", nullable = false)
    private boolean display;

    @Column(name = "display_order", nullable = false)
    private int displayOrder;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
}
