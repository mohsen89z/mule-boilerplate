package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

/**
 * Created by sima on 10/18/15.
 * sima.ahmadvand@gmail.com
 */
public interface UserGroupDao {

    UserGroup findDefaultUserGroup() throws DatabaseException;
}
