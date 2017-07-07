package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.Notification;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

import java.util.List;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
public interface NotificationDao {

    void save(Notification notification) throws DatabaseException;

    List<Notification> getAppUpdateNotificationRecords(int maxNotificationMessagePerJob) throws DatabaseException;

    void updateNotificationsToReadyToSend(int maxNotificationMessagePerJob) throws DatabaseException;

    long getAppUpdateNotificationMessageCounts() throws DatabaseException;

    void removeAll(List<Notification> notifications) throws DatabaseException;
}
