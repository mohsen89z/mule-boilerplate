package xyz.homapay.hampay.core.server.service;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.dao.AccountDao;
import xyz.homapay.hampay.core.server.dao.impl.AccountDaoImpl;

import java.util.List;

/**
 * Created by sima on 7/21/15.
 */
public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void updateAccount(Account account) throws DatabaseException {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Account account) throws DatabaseException {
        accountDao.deleteAccount(account);
    }

    public List<Account> getRecentTransactionAccountsByCustomerId(ObjectId customerId, int number) throws DatabaseException {
        return accountDao.getRecentTransactionAccountsByCustomerId(customerId, number);
    }
}
