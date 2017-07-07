package xyz.homapay.hampay.core.common.comparator;

import xyz.homapay.hampay.core.common.data.model.Transaction;

import java.util.Comparator;

/**
 * Created by sima on 8/5/15.
 */
public class TransactionDateComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction transaction1, Transaction transaction2) {
        return transaction2.getTransactionDate().compareTo(transaction1.getTransactionDate());
    }
}
