package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.Event;
import xyz.homapay.hampay.core.server.dao.EventDao;
import xyz.homapay.hampay.core.server.dao.impl.EventDaoImpl;

import java.util.List;

/**
 * Created by sima on 8/16/15.
 */
public class EventService {

    private EventDao eventDao = new EventDaoImpl();

    public List<Event> findAllEvents() {
        return eventDao.findAllEvents();
    }
}
