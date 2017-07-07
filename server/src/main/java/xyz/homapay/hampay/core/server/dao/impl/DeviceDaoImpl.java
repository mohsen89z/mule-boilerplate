package xyz.homapay.hampay.core.server.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.UserDevice;
import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.DeviceNotFoundException;
import xyz.homapay.hampay.core.server.dao.DeviceDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;

/**
 * Created by sima on 7/20/15.
 */
public class DeviceDaoImpl implements DeviceDao {

    @Override
    public UserDevice findDeviceById(ObjectId id) throws DeviceNotFoundException {
        UserDevice userDevice;
        try {
            userDevice = DbConnection.datastore().find(UserDevice.class).field("id").equal(id).get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DeviceNotFoundException();
        }
        if (userDevice == null)
            throw new DeviceNotFoundException();
        return userDevice;
    }

    @Override
    public UserDevice findDeviceByDeviceId(String deviceId, ObjectId userObjectId) throws DeviceNotFoundException {
        UserDevice userDevice;
        try {
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class).field("id").equal(userObjectId);
            Query<UserDevice> userDeviceQuery = DbConnection.datastore().find(UserDevice.class).field("deviceId").equal(deviceId);
            userDeviceQuery.criteria("user").in(userQuery.asKeyList());
            userDevice = userDeviceQuery.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DeviceNotFoundException();
        }
        if (userDevice == null)
            throw new DeviceNotFoundException();
        return userDevice;
    }

    @Override
    public void updateUserDevice(UserDevice userDevice) throws DatabaseException {
        try {
            DbConnection.datastore().save(userDevice);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public long getOutOfDateUsersCount(Version version) throws DatabaseException {
        try {
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class);
            userQuery.criteria("isActive").equal(true);
            Query<UserDevice> userDeviceQuery = DbConnection.datastore().createQuery(UserDevice.class).field("osName").equal(version.getOs())
                    .field("appVersion").notEqual(version.getName()).field("registrationId").exists();
            userDeviceQuery.criteria("user").in(userQuery.asKeyList());
            return userDeviceQuery.countAll();

        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public List<UserDevice> getOutOfDateUserRegistrationIdsInRange(int beginIndex, int endIndex, Version version) throws DatabaseException {
        try {
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class);
            userQuery.criteria("isActive").equal(true);
            Query<UserDevice> userDeviceQuery = DbConnection.datastore().createQuery(UserDevice.class).field("osName").equal(version.getOs())
                    .field("appVersion").notEqual(version.getName()).field("registrationId")
                    .exists().offset(beginIndex).limit(endIndex).retrievedFields(true, "registrationId");
            userDeviceQuery.criteria("user").in(userQuery.asKeyList());
            return userDeviceQuery.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public void save(UserDevice device) throws DatabaseException {
        try {
            DbConnection.datastore().save(device);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }

    }
}
