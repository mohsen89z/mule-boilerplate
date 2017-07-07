package xyz.homapay.hampay.core.server.dao;

import org.bson.types.ObjectId;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.RegistrationInvalidStepException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;

import java.util.List;
import java.util.Set;

/**
 * Created by sima on 7/20/15.
 */
public interface UserDao {

    User findUserById(ObjectId id) throws UserNotFoundException, DatabaseException;

    User findUserByUserIdToken(String userIdToken) throws UserNotFoundException, DatabaseException;

    User findActivatedUserByUserId(String userId) throws UserNotFoundException, DatabaseException;

    void updateUserVerificationStatusToVerified(String userTokenId) throws RegistrationInvalidStepException;

    User updateLastAndRecentLoginDate(User user) throws UserNotFoundException, DatabaseException;

    void updateTACDateById(ObjectId id);

    void updateUser(User user) throws DatabaseException;

    User findUserByNationalCode(String nationalCode) throws DatabaseException, UserNotFoundException;

    List<User> findActivatedUserByCellNumber(Set<String> numbers) throws DatabaseException;

    List<User> findAllActivedUsersByCellNumber(String cellNumber) throws DatabaseException;

    void insertImage(byte[] image, ObjectId id) throws DatabaseException;

    String findUserImageFileNameById(ObjectId id) throws DatabaseException;

    byte[] findUserImageByFileName(String fileName) throws DatabaseException;

    void updateUserEmail(String email, ObjectId id) throws DatabaseException;

    User findUserByUserId(String nationalCode) throws DatabaseException;

    User findActivatedUserByCellNumber(String cellNumber) throws DatabaseException, UserNotFoundException;
}
