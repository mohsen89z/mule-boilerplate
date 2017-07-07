package xyz.homapay.hampay.core.server.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.VerificationHistory;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.VerificationHistoryNotFoundException;
import xyz.homapay.hampay.core.server.dao.VerificationHistoryDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.List;

/**
 * Created by sima on 8/12/15.
 */
public class VerificationHistoryDaoImpl implements VerificationHistoryDao {
    @Override
    public VerificationHistory findUnsettledVerificationByUserId(ObjectId userId, String accountNumber) throws DatabaseException, VerificationHistoryNotFoundException {
        List<VerificationHistory> verificationHistories;
        try {
            Query<VerificationHistory> query = DbConnection.datastore().find(VerificationHistory.class)
                    .field("user").equal(new Key<>(User.class, userId)).field("account").equal(accountNumber).field("settled").equal(false);
            verificationHistories = query.asList();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (verificationHistories.size() == 0)
            throw new VerificationHistoryNotFoundException();
        else if (verificationHistories.size() != 1)
            throw new RuntimeException();
        return verificationHistories.get(0);
    }

    @Override
    public void saveUserVerificationHistory(VerificationHistory verificationHistory) {
        try {
            DbConnection.datastore().save(verificationHistory);
        } catch (IOException e) {
            //todo what if user verification history could not be updated
        }
    }

    @Override
    public void updateUserVerificationHistory(VerificationHistory verificationHistory) {
        try {
            Query<VerificationHistory> query = DbConnection.datastore().find(VerificationHistory.class)
                    .field("id").equal(verificationHistory.getId());
            UpdateOperations<VerificationHistory> updateOperations = DbConnection.datastore().createUpdateOperations(VerificationHistory.class).set("settled", verificationHistory.isSettled());
            DbConnection.datastore().update(query, updateOperations);
        } catch (Exception e) {
            //todo what if user could not be updated
        }
    }

}
