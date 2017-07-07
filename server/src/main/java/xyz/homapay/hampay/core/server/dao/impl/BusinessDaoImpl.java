package xyz.homapay.hampay.core.server.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.exception.BusinessNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.BusinessDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by sima on 7/30/15.
 */
public class BusinessDaoImpl implements BusinessDao {

    @Override
    public Business findBusinessByAccountId(ObjectId accountId) throws BusinessNotFoundException {
        Business business = null;
        try {
            Query<Account> accountQuery = DbConnection.datastore().createQuery(Account.class).field("id").equal(accountId);
            Query<Business> businessQuery = DbConnection.datastore().createQuery(Business.class);
            businessQuery.criteria("defaultAccount").in(accountQuery.asKeyList());
            business = businessQuery.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (business == null)
            throw new BusinessNotFoundException();
        return business;
    }

    @Override
    public List<Business> getAllBusinesses(Integer pageSize, Integer pageNumber) throws DatabaseException {
        try {
            Query<Business> bizQuery = DbConnection.datastore().find(Business.class);
            bizQuery.offset(pageSize * pageNumber).limit(pageSize);
            return bizQuery.asList();
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }

    @Override
    public Business findBusinessByCode(String code) throws BusinessNotFoundException, DatabaseException {
        Business business;
        try {
            Query<Business> bizQuery = DbConnection.datastore().find(Business.class).field("identityCode").equal(code);
            business = bizQuery.get();
        } catch (IOException e) {
            throw new DatabaseException();
        }
        if (business == null)
            throw new BusinessNotFoundException();
        return business;
    }

    @Override
    public List<Business> findBusinessByTermTitleInRange(String term, Integer pageSize, Integer pageNumber) throws DatabaseException {
        try {
            Pattern regexp = Pattern.compile(term, Pattern.CASE_INSENSITIVE);
            Query bizQuery = DbConnection.datastore().createQuery(Business.class).filter("name", regexp);
            bizQuery.offset(pageSize * pageNumber).limit(pageSize);
            return bizQuery.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }
}
