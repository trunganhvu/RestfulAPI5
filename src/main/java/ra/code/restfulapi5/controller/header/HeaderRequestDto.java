package ra.code.restfulapi5.controller.header;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Getter
@Setter
public class HeaderRequestDto {
    @NotNull
    @JsonProperty("imageDefaultPath")
    private String imageDefaultPath;

    @NotNull
    @JsonProperty("imageDefaultName")
    private String imageDefaultName;

    @JsonProperty("imageEventPath")
    private String imageEventPath;

    @JsonProperty("imageEventName")
    private String imageEventName;

    public HeaderRequestDto() {
    }

    public HeaderRequestDto(String imageDefaultPath, String imageDefaultName, String imageEventPath, String imageEventName) {
        this.imageDefaultPath = imageDefaultPath;
        this.imageDefaultName = imageDefaultName;
        this.imageEventPath = imageEventPath;
        this.imageEventName = imageEventName;
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
