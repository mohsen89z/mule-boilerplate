package xyz.homapay.hampay.core.server.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import xyz.homapay.hampay.core.common.data.model.Notification;
import xyz.homapay.hampay.core.common.data.model.NotificationStatus;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.NotificationDao;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.server.service.annotation.Retry;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
public class NotificationDaoImpl implements NotificationDao {

    @Override
    public void save(Notification notification) throws DatabaseException {
        try {
            DbConnection.datastore().save(notification);
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public List<Notification> getAppUpdateNotificationRecords(int maxNotificationMessagePerJob) throws DatabaseException {
        try {
            return DbConnection.datastore().find(Notification.class).field("machineName").equal(InetAddress.getLocalHost().getHostName())
                    .field("notificationStatus").equal(NotificationStatus.SENDING)
                    .limit(maxNotificationMessagePerJob).asList();
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }

    @Override
    @Retry(times = 3, on = ConcurrentModificationException.class)
    public void updateNotificationsToReadyToSend(int maxNotificationMessagePerJob) throws DatabaseException {

        try {
            Query<Notification> query = DbConnection.datastore().find(Notification.class).field("notificationStatus")
                    .equal(NotificationStatus.READY_TO_SEND).limit(maxNotificationMessagePerJob);
            Query<Notification> updateQuery = DbConnection.datastore().find(Notification.class).field("id").hasAnyOf(getIdList(query.asKeyList()));
            UpdateOperations<Notification> updateOperations = DbConnection.datastore().createUpdateOperations(Notification.class)
                    .set("machineName", InetAddress.getLocalHost().getHostName())
                    .set("notificationStatus", NotificationStatus.SENDING);
            DbConnection.datastore().update(updateQuery, updateOperations);
        } catch (IOException e) {
            e.printStackTrace();
//            todo what if user could not be updated
        }
    }

    //    There is no other wy to support update operation limit
    private List<ObjectId> getIdList(List<Key<Notification>> keys) {
        List<ObjectId> ids = new ArrayList<>(keys.size());
        for (Key<Notification> key : keys) {
            ids.add((ObjectId) key.getId());
        }
        return ids;
    }

    @Override
    public long getAppUpdateNotificationMessageCounts() throws DatabaseException {
        try {
            return DbConnection.datastore().find(Notification.class).field("notificationStatus").equal(NotificationStatus.READY_TO_SEND).countAll();
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public void removeAll(List<Notification> notifications) throws DatabaseException {
        try {
            List<ObjectId> ids = new ArrayList<>(notifications.size());
            for (Notification notification : notifications) {
                ids.add(notification.getId());
            }
            Query<Notification> query = DbConnection.datastore().find(Notification.class).field("id").in(ids);
            DbConnection.datastore().delete(query);
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }
}
