package xyz.homapay.hampay.core.server.dao;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.VerificationHistory;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VerificationHistoryNotFoundException;

/**
 * Created by sima on 8/12/15.
 */
public interface VerificationHistoryDao {

    VerificationHistory findUnsettledVerificationByUserId(ObjectId userId, String accountNumber) throws DatabaseException, VerificationHistoryNotFoundException;

    void saveUserVerificationHistory(VerificationHistory verificationHistory);

    void updateUserVerificationHistory(VerificationHistory verificationHistory);

}
