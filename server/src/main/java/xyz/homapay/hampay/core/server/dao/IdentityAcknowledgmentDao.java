package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.IdentityAcknowledgment;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

/**
 * Created by sima on 7/22/15.
 */
public interface IdentityAcknowledgmentDao {

    void save(IdentityAcknowledgment acknowledgment) throws DatabaseException;
}
