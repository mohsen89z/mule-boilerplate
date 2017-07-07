package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.Event;
import xyz.homapay.hampay.core.server.dao.EventDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 8/16/15.
 */
public class EventDaoImpl implements EventDao {
    @Override
    public List<Event> findAllEvents() {
        try {
            return DbConnection.datastore().find(Event.class).asList();
        } catch (IOException ignored) {

        }
        return new ArrayList<>();
    }
}
