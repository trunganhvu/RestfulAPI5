package ra.code.restfulapi5.controller.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Getter
@Setter
public class EventRequestDto {
    @NotNull
    @JsonProperty("eventName")
    private String eventName;

    @NotNull
    @JsonProperty("eventSlogun")
    private String eventSlogun;

    @JsonProperty("eventDescription")
    private String eventDescription;

    @JsonProperty("eventNote")
    private String eventNote;

    @JsonProperty("eventImageBanner")
    private String eventImageBanner;

    @NotNull
    @JsonProperty("active")
    private boolean active;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("eventStart")
    private Date eventStart;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("eventEnd")
    private Date eventEnd;
}
