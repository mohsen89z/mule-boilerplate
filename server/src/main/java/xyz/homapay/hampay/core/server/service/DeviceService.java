package xyz.homapay.hampay.core.server.service;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.UserDevice;
import xyz.homapay.hampay.core.common.data.model.Version;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.DeviceNotFoundException;
import xyz.homapay.hampay.core.server.dao.DeviceDao;

import java.util.List;

/**
 * Created by sima on 7/21/15.
 */
public class DeviceService {

    private DeviceDao deviceDao;

    public void setDeviceDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public void updateUserDevice(UserDevice userDevice) throws DatabaseException {
        deviceDao.updateUserDevice(userDevice);
    }

    public UserDevice findDeviceByDeviceId(String deviceId, ObjectId userObjectId) throws DeviceNotFoundException {
        return deviceDao.findDeviceByDeviceId(deviceId, userObjectId);
    }

    public long getOutOfDateUsersCount(Version version) throws DatabaseException {
        return deviceDao.getOutOfDateUsersCount(version);
    }

    public List<UserDevice> getOutOfDateUsersInRange(int beginIndex, int endIndex, Version version) throws DatabaseException {
        return deviceDao.getOutOfDateUserRegistrationIdsInRange(beginIndex, endIndex, version);
    }

    public void save(UserDevice device) throws DatabaseException {
        deviceDao.save(device);
    }
}
