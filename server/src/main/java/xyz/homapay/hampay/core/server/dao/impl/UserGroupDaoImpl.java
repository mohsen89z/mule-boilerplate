package xyz.homapay.hampay.core.server.dao.impl;

import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.UserGroupDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
public class UserGroupDaoImpl implements UserGroupDao {

    @Override
    public UserGroup findDefaultUserGroup() throws DatabaseException {
        try {
            Query<UserGroup> query = DbConnection.datastore().find(UserGroup.class).field("default").equal(true);
            return query.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }
}
