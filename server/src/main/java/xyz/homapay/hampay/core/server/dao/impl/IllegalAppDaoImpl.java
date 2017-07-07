package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.IllegalApp;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.IllegalAppDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;

/**
 * Created by sima on 10/21/15.
 * sima.ahmadvand@gmail.com
 */
public class IllegalAppDaoImpl implements IllegalAppDao {

    @Override
    public List<IllegalApp> getAll() throws DatabaseException {
        try {
            return DbConnection.datastore().find(IllegalApp.class).asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }
}
