package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.exception.InvalidBankCodeException;
import xyz.homapay.hampay.core.server.dao.BankDao;
import xyz.homapay.hampay.core.server.dao.impl.BankDaoImpl;

/**
 * Created by sima on 7/21/15.
 */
public class BankService {
    private BankDao bankDao = new BankDaoImpl();

    public Bank getBankByCodeFromCachedList(String bankCode) throws InvalidBankCodeException {
        return bankDao.getBankByCodeFromCachedList(bankCode);
    }
}
