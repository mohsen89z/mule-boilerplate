package xyz.homapay.hampay.core.server.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.exception.AccountNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.AccountDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sima on 7/20/15.
 */
public class AccountDaoImpl implements AccountDao {

    @Override
    public Account findAccountById(ObjectId id) throws AccountNotFoundException, DatabaseException {
        Account account;
        try {
            account = DbConnection.datastore().find(Account.class).field("id").equal(id).get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        if (account == null)
            throw new AccountNotFoundException();
        return account;
    }

    @Override
    public void updateAccount(Account account) throws DatabaseException {
        try {
            DbConnection.datastore().save(account);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public void deleteAccount(Account account) throws DatabaseException {
        try {
            DbConnection.datastore().delete(account);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public List<Account> findAccountsById(Set<ObjectId> accountIds) throws DatabaseException {
        try {
            Query<Account> accountQuery = DbConnection.datastore().createQuery(Account.class);
            accountQuery.criteria("id").in(accountIds);
            return accountQuery.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public List<Account> getRecentTransactionAccountsByCustomerId(ObjectId customerId, int number) throws DatabaseException {

        Set<ObjectId> customerAccountIds = new HashSet<>(number);
        try {
            Query<IndividualCustomer> customerQuery = DbConnection.datastore().createQuery(IndividualCustomer.class)
                    .field("id").equal(customerId);
            Query<Account> sourceAccountQuery = DbConnection.datastore().createQuery(Account.class);
            Query<Transaction> transactionQuery = DbConnection.datastore().createQuery(Transaction.class);
            sourceAccountQuery.criteria("customer").in(customerQuery.asKeyList());
            transactionQuery.criteria("sourceAccount").in(sourceAccountQuery.asKeyList());
            transactionQuery.field("personType").equal(Transaction.PersonType.INDIVIDUAL);

            List<DBObject> dbObjectList = transactionQuery.getCollection().find(transactionQuery.getQueryObject()).sort(new BasicDBObject("transactionDate", -1)).toArray();

            for (DBObject dbObject : dbObjectList) {
                ObjectId objectId = (ObjectId) ((DBRef) dbObject.get("destinationAccount")).getId();
                customerAccountIds.add(objectId);
                if (customerAccountIds.size() == number)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        if (customerAccountIds.size() > 0)
            return findAccountsById(customerAccountIds);

        return new ArrayList<>();
    }

}
