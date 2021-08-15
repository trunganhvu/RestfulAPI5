package ra.code.restfulapi5.controller.header;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class HeaderResponseDto {
    private Long id;

    private String imageDefaultPath;

    private String imageDefaultName;

    private String imageEventPath;

    private String imageEventName;

    public HeaderResponseDto() {
    }

    public HeaderResponseDto(Long id, String imageDefaultPath, String imageDefaultName, String imageEventPath, String imageEventName) {
        this.id = id;
        this.imageDefaultPath = imageDefaultPath;
        this.imageDefaultName = imageDefaultName;
        this.imageEventPath = imageEventPath;
        this.imageEventName = imageEventName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageDefaultPath() {
        return imageDefaultPath;
    }

    public void setImageDefaultPath(String imageDefaultPath) {
        this.imageDefaultPath = imageDefaultPath;
    }

    public String getImageDefaultName() {
        return imageDefaultName;
    }

    public void setImageDefaultName(String imageDefaultName) {
        this.imageDefaultName = imageDefaultName;
    }

    public String getImageEventPath() {
        return imageEventPath;
    }

    public void setImageEventPath(String imageEventPath) {
        this.imageEventPath = imageEventPath;
    }

    public String getImageEventName() {
        return imageEventName;
    }

    public void setImageEventName(String imageEventName) {
        this.imageEventName = imageEventName;
    }
}
