package xyz.homapay.hampay.core.test.dao;

import org.bson.types.ObjectId;
import org.junit.Test;
import xyz.homapay.hampay.core.server.dao.impl.AccountDaoImpl;

/**
 * Created by sima on 8/15/15.
 */
public class AccountDaoTest {
    private AccountDaoImpl accountDao = new AccountDaoImpl();

    @Test
    public void testGetRecentTransactionAccountsByCustomerId() throws Exception {
        accountDao.getRecentTransactionAccountsByCustomerId(new ObjectId("55cdd8fbe4b065921a295e9a"), 4);
    }
}
