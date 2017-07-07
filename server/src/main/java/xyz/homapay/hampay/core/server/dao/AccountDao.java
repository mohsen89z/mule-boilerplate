package xyz.homapay.hampay.core.server.dao;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.exception.AccountNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;

import java.util.List;
import java.util.Set;

/**
 * Created by sima on 7/20/15.
 */
public interface AccountDao {

    Account findAccountById(ObjectId id) throws AccountNotFoundException, DatabaseException;

    void updateAccount(Account account) throws DatabaseException;

    void deleteAccount(Account account) throws DatabaseException;

    List<Account> findAccountsById(Set<ObjectId> accountIds) throws DatabaseException;

    List<Account> getRecentTransactionAccountsByCustomerId(ObjectId customerId, int number) throws DatabaseException;

}
