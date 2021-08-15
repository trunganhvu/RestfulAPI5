package ra.code.restfulapi5.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ra.code.restfulapi5.common.util.DateTime;
import ra.code.restfulapi5.common.variableconst.CommonConst;
import ra.code.restfulapi5.model.Event;
import ra.code.restfulapi5.repository.IEventRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author trunganhvu
 * 2021/08/15
 */
@Service
public class EventService implements IEventService{

    @Autowired
    private IEventRepository eventRepository;
    /**
     * Get events
     * @return List event
     */
    @Cacheable(value = "events", key = "'CACHE_KEY_EVENTS'", sync = true)
    @Override
    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    /**
     * Get event by id
     * @param id
     * @return Event
     */
    @Cacheable(value = "event",key = "#id", sync = true)
    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    /**
     * Save event
     * @param event
     * @return Event
     */
    @Caching(
        evict = {
                @CacheEvict(value = "events", key = "'CACHE_KEY_EVENTS'",  beforeInvocation = true),
                @CacheEvict(value = "events-active", key = "'CACHE_KEY_EVENTS_ACTIVE'",  beforeInvocation = true)
        },
        put = {
                @CachePut(value = "event", key = "#event.eventId")
        }
    )
    @Override
    public Event save(Event event) {
        if (event.getEventId() == null) {
            event.setCreatedAt(DateTime.getDateyyyyMMddhhmmss());
        } else {
            event.setUpdatedAt(DateTime.getDateyyyyMMddhhmmss());
        }
        return eventRepository.save(event);
    }

    /**
     * Delete event
     * @param id
     */
    @Caching(
        evict = {
            @CacheEvict(value = "events", key = "'CACHE_KEY_EVENTS'"),
            @CacheEvict(value = "events-active", key = "'CACHE_KEY_EVENTS_ACTIVE'"),
            @CacheEvict(value = "event", key = "#id")
        }
    )
    @Override
    public void remove(Long id) {
        eventRepository.deleteById(id);
    }

    /**
     * Get events is active
     * @return List event
     */
    @Cacheable(value = "events-active", key = "'CACHE_KEY_EVENTS_ACTIVE'", sync = true)
    @Override
    public List<Event> getEventActive() {
        return eventRepository.getEventActive(CommonConst.ACTIVE_TRUE);
    }
}
