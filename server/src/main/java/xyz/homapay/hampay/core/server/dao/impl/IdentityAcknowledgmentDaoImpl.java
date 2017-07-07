package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.IdentityAcknowledgment;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.IdentityAcknowledgmentDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;

/**
 * Created by sima on 7/22/15.
 */
public class IdentityAcknowledgmentDaoImpl implements IdentityAcknowledgmentDao {

    @Override
    public void save(IdentityAcknowledgment acknowledgment) throws DatabaseException {
        try {
            DbConnection.datastore().save(acknowledgment);
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }
}
