package ra.code.restfulapi5.controller.category;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Category request dto: create, update
 * @author trunganhvu
 * 2021/08/13
 */
@Getter
@Setter
public class CategoryRequestDto {

    @NotNull
    @JsonProperty("categoryUrl")
    private String categoryUrl;

    @NotNull
    @JsonProperty("categoryName")
    private String categoryName;

    @NotNull
    @JsonProperty("categoryImageDefault")
    private String categoryImageDefault;

    @NotNull
    @JsonProperty("categoryImageDefaultName")
    private String categoryImageDefaultName;

    @JsonProperty("categoryImageEvent")
    private String categoryImageEvent;

    @JsonProperty("categoryImageEventName")
    private String categoryImageEventName;

    @JsonProperty("categoryImageEventStart")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date categoryImageEventStart;

    @JsonProperty("categoryImageEventEnd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date categoryImageEventEnd;

    @NotNull
    @JsonProperty("display")
    private boolean display;

    @NotNull
    @JsonProperty("displayOrder")
    private int displayOrder;
}
