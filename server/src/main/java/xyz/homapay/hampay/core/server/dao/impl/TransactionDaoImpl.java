package xyz.homapay.hampay.core.server.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.mongodb.morphia.query.Query;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.TransactionNotFoundException;
import xyz.homapay.hampay.core.server.dao.TransactionDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 8/1/15.
 */
public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void save(Transaction transaction) throws DatabaseException {
        try {
            DbConnection.datastore().save(transaction);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }

    }

    @Override
    public List<Transaction> findTransactionRangeByUserId(String userId, Integer pageSize, Integer pageNumber) throws DatabaseException {
        List<Transaction> transactions = new ArrayList<>(pageNumber);

        try {
            Query<Transaction> transactionQuery = DbConnection.datastore().createQuery(Transaction.class);
            Query<Account> accountQuery = DbConnection.datastore().createQuery(Account.class);
            Query<IndividualCustomer> customerQuery = DbConnection.datastore().createQuery(IndividualCustomer.class);
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class);

            userQuery.criteria("userId").equal(userId);
            customerQuery.criteria("users").in(userQuery.asKeyList());
            accountQuery.criteria("customer").in(customerQuery.asKeyList());
            transactionQuery.or(
                    transactionQuery.criteria("sourceAccount").in(accountQuery.asKeyList()),
                    transactionQuery.criteria("destinationAccount").in(accountQuery.asKeyList())
            );
            List<DBObject> dbObjectList = transactionQuery.getCollection().find(transactionQuery.getQueryObject())
                    .sort(new BasicDBObject("transactionDate", -1)).skip(pageSize * pageNumber).limit(pageSize).toArray();
            for (DBObject dbObject : dbObjectList) {
                transactions.add(DbConnection.morphia().fromDBObject(Transaction.class, dbObject));
            }

            return transactions;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public Transaction findTransactionByReferenceCode(String referenceCode) throws DatabaseException, TransactionNotFoundException {
        Transaction transaction;
        try {
            transaction = DbConnection.datastore().find(Transaction.class).field("reference").equal(referenceCode).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (transaction == null)
            throw new TransactionNotFoundException();
        return transaction;
    }

}
