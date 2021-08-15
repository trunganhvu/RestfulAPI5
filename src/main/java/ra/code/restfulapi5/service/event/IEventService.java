package ra.code.restfulapi5.service.event;

import ra.code.restfulapi5.model.Event;
import ra.code.restfulapi5.service.IGeneralService;

import java.util.List;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public interface IEventService extends IGeneralService<Event> {

    /**
     * Get events is active
     * @return List event
     */
    public List<Event> getEventActive();
}
