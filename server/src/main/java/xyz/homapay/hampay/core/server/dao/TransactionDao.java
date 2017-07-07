package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.TransactionNotFoundException;

import java.util.List;

/**
 * Created by sima on 8/1/15.
 */
public interface TransactionDao {

    void save(Transaction transaction) throws DatabaseException;

    List<Transaction> findTransactionRangeByUserId(String userId, Integer pageSize, Integer pageNumber) throws DatabaseException;

    Transaction findTransactionByReferenceCode(String referenceCode) throws DatabaseException, TransactionNotFoundException;
}
