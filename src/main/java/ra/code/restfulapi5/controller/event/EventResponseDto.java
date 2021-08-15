package ra.code.restfulapi5.controller.event;

import java.util.Date;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class EventResponseDto {
    private Long eventId;

    private String eventName;

    private String eventSlogun;

    private String eventDescription;

    private String eventNote;

    private String eventImageBanner;

    private boolean active;

    private Date eventStart;

    private Date eventEnd;

    public EventResponseDto() {
    }

    public EventResponseDto(Long eventId, String eventName, String eventSlogun, String eventDescription, String eventNote, String eventImageBanner, boolean active, Date eventStart, Date eventEnd) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSlogun = eventSlogun;
        this.eventDescription = eventDescription;
        this.eventNote = eventNote;
        this.eventImageBanner = eventImageBanner;
        this.active = active;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventSlogun() {
        return eventSlogun;
    }

    public void setEventSlogun(String eventSlogun) {
        this.eventSlogun = eventSlogun;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public String getEventImageBanner() {
        return eventImageBanner;
    }

    public void setEventImageBanner(String eventImageBanner) {
        this.eventImageBanner = eventImageBanner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventStart(Date eventStart) {
        this.eventStart = eventStart;
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(Date eventEnd) {
        this.eventEnd = eventEnd;
    }
}
