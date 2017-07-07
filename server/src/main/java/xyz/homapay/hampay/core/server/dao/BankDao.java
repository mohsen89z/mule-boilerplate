package xyz.homapay.hampay.core.server.dao;

import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.exception.InvalidBankCodeException;

import java.util.List;

/**
 * Created by sima on 7/20/15.
 */
public interface BankDao {

    List<Bank> getAllBanks();

    List<Bank> getCachedBankList();

    Bank getBankByCodeFromCachedList(String bankCode) throws InvalidBankCodeException;
}
