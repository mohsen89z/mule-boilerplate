package xyz.homapay.hampay.core.server.dao;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.exception.BusinessNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

import java.util.List;

/**
 * Created by sima on 7/30/15.
 */
public interface BusinessDao {
    Business findBusinessByAccountId(ObjectId accountId) throws BusinessNotFoundException;

    List<Business> getAllBusinesses(Integer pageSize, Integer pageNumber) throws DatabaseException;

    Business findBusinessByCode(String code) throws BusinessNotFoundException, DatabaseException;

    List<Business> findBusinessByTermTitleInRange(String term, Integer pageSize, Integer pageNumber) throws DatabaseException;
}
