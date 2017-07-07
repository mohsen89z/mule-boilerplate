package xyz.homapay.hampay.core.server.dao.impl;

import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.exception.InvalidBankCodeException;
import xyz.homapay.hampay.core.server.dao.BankDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sima on 7/20/15.
 */
public class BankDaoImpl implements BankDao {

    public List<Bank> getAllBanks() {
        try {
            return DbConnection.datastore().find(Bank.class).asList();
        } catch (IOException ignored) {

        }
        return new ArrayList<>();
    }

    private static List<Bank> cachedBankList;

    public List<Bank> getCachedBankList() {
        if (cachedBankList == null || cachedBankList.size() == 0) {
            cachedBankList = getAllBanks();
            return cachedBankList;
        } else return cachedBankList;

    }

    public Bank getBankByCodeFromCachedList(String bankCode) throws InvalidBankCodeException {
        if (cachedBankList == null || cachedBankList.size() == 0)
            cachedBankList = getAllBanks();
        for (Bank bank : cachedBankList) {
            if (bank.getCode().equals(bankCode))
                return bank;
        }
        throw new InvalidBankCodeException();
    }
}
