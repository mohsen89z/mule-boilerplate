package xyz.homapay.hampay.core.server.service;

import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.VerificationHistory;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VerificationHistoryNotFoundException;
import xyz.homapay.hampay.core.server.dao.VerificationHistoryDao;
import xyz.homapay.hampay.core.server.dao.impl.VerificationHistoryDaoImpl;

import java.util.Date;

/**
 * Created by sima on 8/12/15.
 */
public class VerificationHistoryService {

    private VerificationHistoryDao verificationHistoryDao = new VerificationHistoryDaoImpl();

    public VerificationHistory findUnsettledVerificationByUserId(User user) throws DatabaseException, VerificationHistoryNotFoundException {
        return verificationHistoryDao.findUnsettledVerificationByUserId(user.getId(), user.getCustomer().getDefaultAccount().getAccountNumber());
    }

    public void saveUserVerificationHistory(VerificationHistory verificationHistory) {
        verificationHistoryDao.saveUserVerificationHistory(verificationHistory);
    }

    public void updateUserVerificationHistory(VerificationHistory verificationHistory) {
        verificationHistoryDao.updateUserVerificationHistory(verificationHistory);
    }

    public void updateVerificationHistoryToSettled(VerificationHistory verificationHistory) throws DatabaseException {
        verificationHistory.setSettled(true);
        updateUserVerificationHistory(verificationHistory);
    }

    public void createAndSaveUserVerificationHistoryForUser(User user, Integer amount) {
        VerificationHistory verificationHistory = new VerificationHistory();
        verificationHistory.setActionDate(new Date());
        verificationHistory.setAmount(amount);
        verificationHistory.setSettled(false);
        verificationHistory.setAccountNumber(user.getCustomer().getDefaultAccount().getAccountNumber());
        verificationHistory.setUser(user);
        saveUserVerificationHistory(verificationHistory);
    }

    public VerificationHistory getUnsettledVerificationHistoryStatus(User user) throws DatabaseException {
        try {
            VerificationHistory verificationHistory = findUnsettledVerificationByUserId(user);
            if (verificationHistory.getAccountNumber().equals(user.getCustomer().getDefaultAccount().getAccountNumber()))
                return verificationHistory;
        } catch (VerificationHistoryNotFoundException ignored) {

        }
        return null;
    }
}
