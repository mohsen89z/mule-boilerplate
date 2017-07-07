package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.IllegalApp;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.IllegalAppDao;

import java.util.List;

/**
 * Created by sima on 10/21/15.
 * sima.ahmadvand@gmail.com
 */
public class IllegalAppsService {

    private IllegalAppDao illegalAppDao;

    public void setIllegalAppDao(IllegalAppDao illegalAppDao) {
        this.illegalAppDao = illegalAppDao;
    }

    public List<IllegalApp> getAllIllegalApps() throws DatabaseException {
        return illegalAppDao.getAll();
    }
}
