package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.Event;

import java.util.List;

/**
 * Created by sima on 8/16/15.
 */
public interface EventDao {

    List<Event> findAllEvents();

}
