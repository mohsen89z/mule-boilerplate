package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.IllegalApp;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

import java.util.List;

/**
 * Created by sima on 10/21/15.
 * sima.ahmadvand@gmail.com
 */
public interface IllegalAppDao {

    List<IllegalApp> getAll() throws DatabaseException;

}
