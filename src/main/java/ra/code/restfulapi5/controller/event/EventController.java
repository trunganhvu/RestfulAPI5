package ra.code.restfulapi5.controller.event;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.code.restfulapi5.common.util.Validator;
import ra.code.restfulapi5.model.Event;
import ra.code.restfulapi5.service.event.IEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private IEventService eventService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Get all event
     * @return list event
     */
    @GetMapping
    public ResponseEntity<Iterable<EventResponseDto>> getAllEvent() {
        // Get all event
        List<Event> eventList = new ArrayList<>();
        eventService.findAll().forEach(eventList::add);

        List<EventResponseDto> result = new ArrayList<>();
        eventList.forEach(event -> {
            result.add(convertEventToEventResponseDto(event));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get event by id
     * @param id
     * @return EventResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) {
        // Get event by id
        Optional<Event> eventOptional = eventService.findById(id);

        return eventOptional
                .map(event -> new ResponseEntity<>(convertEventToEventResponseDto(event), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get events is active
     * @return list event
     */
    @GetMapping("/active")
    public ResponseEntity<List<EventResponseDto>> getEventActive() {
        // Get list event
        List<Event> eventList = eventService.getEventActive();

        // Map entity to response dto
        List<EventResponseDto> result = new ArrayList<>();
        eventList.forEach(event -> {
            result.add(convertEventToEventResponseDto(event));
        });
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create new event
     * @param eventRequestDto
     * @return EventResponseDto
     */
    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventRequestDto eventRequestDto) {
        // Check start <= end
        if (!Validator.startIsLQEnd(eventRequestDto.getEventStart(),
                eventRequestDto.getEventEnd())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Map request dto to entity
        Event event = convertEventRequestDtoToEvent(eventRequestDto);

        // Save
        return new ResponseEntity<>(
                convertEventToEventResponseDto(eventService.save(event)),
                HttpStatus.OK
        );
    }

    /**
     * Update event by id
     * @param id
     * @param eventRequestDto
     * @return EventResponseDto
     */
    @PostMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id,
                                                        @RequestBody EventRequestDto eventRequestDto) {
        // Check start <= end
        if (!Validator.startIsLQEnd(eventRequestDto.getEventStart(),
                eventRequestDto.getEventEnd())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Get event by id
        Optional<Event> eventOptional = eventService.findById(id);

        // Map request dto to entity
        Event event = convertEventRequestDtoToEvent(eventRequestDto);

        // Save
        return eventOptional.map(event1 -> {
            event.setEventId(event1.getEventId());
            event.setCreatedAt(event1.getCreatedAt());
            return new ResponseEntity<>(
                    convertEventToEventResponseDto(eventService.save(event)),
                    HttpStatus.OK
            );
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete event by id
     * @param id
     * @return DeleteEventResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEventResponseDto> deleteEvent(@PathVariable Long id) {
        // Find event by id
        Optional<Event> eventOptional = eventService.findById(id);

        // Remove event
        DeleteEventResponseDto result = new DeleteEventResponseDto(true);
        return eventOptional.map(event -> {
            eventService.remove(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Convert Event to EventResponseDto
     * @param event
     * @return EventResponseDto
     */
    private EventResponseDto convertEventToEventResponseDto(Event event) {
        return modelMapper.map(event, EventResponseDto.class);
    }

    /**
     * Convert Event Request Dto to Event entity
     * @param eventRequestDto
     * @return Event
     */
    private Event convertEventRequestDtoToEvent(EventRequestDto eventRequestDto) {
        return modelMapper.map(eventRequestDto, Event.class);
    }
}
