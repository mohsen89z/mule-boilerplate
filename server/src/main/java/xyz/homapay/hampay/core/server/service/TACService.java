package xyz.homapay.hampay.core.server.service;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.UserDevice;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.DeviceNotFoundException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.server.dao.TACDao;
import xyz.homapay.hampay.core.server.helper.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Created by sima on 7/2/15.
 */
public class TACService {

    private UserService userService;
    private DeviceService deviceService;
    private TACDao tacDao;

    public void setTacDao(TACDao tacDao) {
        this.tacDao = tacDao;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public void checkAppVersion(String deviceId, String appVersion, User user) throws DeviceNotFoundException, DatabaseException {
        UserDevice userDevice = deviceService.findDeviceByDeviceId(deviceId, user.getId());
        if (userDevice.getAppVersion() == null || !userDevice.getAppVersion().equals(appVersion)) {
            userDevice.setAppVersion(appVersion);
            deviceService.updateUserDevice(userDevice);
        }
    }


    public Date getTACFileLatestUploadDate() throws FileNotFoundException {
        return tacDao.getTACFileLatestUploadDate();
    }


    public void updateUserTACInformation(ObjectId id) {
        userService.updateTACDateById(id);
    }

    public User updateLastAndRecentLoginDate(User user) throws UserNotFoundException, DatabaseException {
        return userService.updateLastAndRecentLoginDate(user);
    }

    public String getTACFileLatestVersionAsString() throws IOException {
        return Util.getFileContentAsString(tacDao.getTACFileLatestVersion());
    }
}
