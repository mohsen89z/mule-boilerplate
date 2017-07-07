package xyz.homapay.hampay.core.server.dao;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.UserDevice;
import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.DeviceNotFoundException;

import java.util.List;

/**
 * Created by sima on 7/20/15.
 */
public interface DeviceDao {

    UserDevice findDeviceById(ObjectId id) throws DeviceNotFoundException;

    UserDevice findDeviceByDeviceId(String deviceId, ObjectId userObjectId) throws DeviceNotFoundException;

    void updateUserDevice(UserDevice userDevice) throws DatabaseException;

    long getOutOfDateUsersCount(Version version) throws DatabaseException;

    List<UserDevice> getOutOfDateUserRegistrationIdsInRange(int beginIndex, int endIndex, Version version) throws DatabaseException;

    void save(UserDevice device) throws DatabaseException;
}
