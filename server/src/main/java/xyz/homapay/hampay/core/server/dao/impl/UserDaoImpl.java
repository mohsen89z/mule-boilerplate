package xyz.homapay.hampay.core.server.dao.impl;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.apache.axis.constants.Use;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.RegistrationInvalidStepException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.server.dao.UserDao;
import xyz.homapay.hampay.core.server.data.DbConnection;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sima on 7/20/15.
 */
public class UserDaoImpl implements UserDao {

    public User findUserById(ObjectId id) throws UserNotFoundException, DatabaseException {
        User user;
        try {
            user = DbConnection.datastore().find(User.class).field("id").equal(id).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }


    public User findUserByUserIdToken(String userIdToken) throws UserNotFoundException, DatabaseException {
        User user;
        try {
            user = DbConnection.datastore().find(User.class).field("userIdToken").equal(userIdToken).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }

    public User findActivatedUserByUserId(String userId) throws UserNotFoundException, DatabaseException {
        User user;
        try {
            user = DbConnection.datastore().find(User.class).field("userId").equal(userId).field("isActive").equal(true).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }

    public void updateUserVerificationStatusToVerified(String userTokenId) throws RegistrationInvalidStepException {
        try {
            Query<User> query = DbConnection.datastore().find(User.class)
                    .field("userIdToken").equal(userTokenId);
            UpdateOperations<User> updateOperations = DbConnection.datastore().createUpdateOperations(User.class)
                    .set("verificationStatus", UserVerificationStatus.VERIFIED);
            DbConnection.datastore().update(query, updateOperations);
        } catch (Exception e) {
            //todo what if user could not be updated
        }
    }

    @Override
    public void updateUser(User user) throws DatabaseException {
        try {
            DbConnection.datastore().save(user);
        } catch (IOException e) {
            throw new DatabaseException();
        }
    }


    public void updateTACDateById(ObjectId id) {
        try {
            Query<User> query = DbConnection.datastore().find(User.class)
                    .field("id").equal(id);
            UpdateOperations<User> updateOperations = DbConnection.datastore().createUpdateOperations(User.class)
                    .set("tacAcceptDate", new Date());
            DbConnection.datastore().update(query, updateOperations);
        } catch (Exception e) {
            //todo what if user could not be updated
        }
    }

    public User updateLastAndRecentLoginDate(User user) throws UserNotFoundException, DatabaseException {
        try {
            Date currentDate = new Date();
            Query<User> query = DbConnection.datastore().find(User.class)
                    .field("id").equal(user.getId());
            UpdateOperations<User> updateOperations = DbConnection.datastore().createUpdateOperations(User.class)
                    .set("recentLoginDate", currentDate);
            if (user.getRecentLoginDate() != null)
                updateOperations.set("lastLoginDate", user.getRecentLoginDate());
            else
                updateOperations.set("lastLoginDate", currentDate);
            DbConnection.datastore().update(query, updateOperations);
        } catch (IOException e) {
            throw new DatabaseException();
        }
        return findUserById(user.getId());
    }

    public User findUserByNationalCode(String nationalCode) throws UserNotFoundException, DatabaseException {
        User user;
        try {
            Query<IndividualCustomer> customerQuery = DbConnection.datastore().createQuery(IndividualCustomer.class).field("identityCode").equal(nationalCode);
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class);
            userQuery.criteria("customer").in(customerQuery.asKeyList());
            user = userQuery.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }

    @Override
    public List<User> findActivatedUserByCellNumber(Set<String> numbers) throws DatabaseException {
        try {
            Query<User> query = DbConnection.datastore().find(User.class);
            query.field("mobileNo").hasAnyOf(numbers).field("isActive").equal(true);
            return query.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public List<User> findAllActivedUsersByCellNumber(String cellNumber) throws DatabaseException {
        try {
            Query<User> query = DbConnection.datastore().find(User.class);
            query.field("mobileNo").equal(cellNumber).field("isActive").equal(true);
            return query.asList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public void insertImage(byte[] image, ObjectId id) throws DatabaseException {
        GridFSDBFile gridFSDBFile;
        try {
            GridFS gridfs = new GridFS(DbConnection.bulkDatastore().getDB());
            gridFSDBFile = gridfs.find(id);
            String fileName = null;
            if (gridFSDBFile != null) {
                fileName = gridFSDBFile.getFilename();
                gridfs.remove(id);
            }
            GridFSInputFile gridFSInputFile = gridfs.createFile(image);
            gridFSInputFile.setId(id);
            gridFSInputFile.setFilename(fileName == null ? UUID.randomUUID().toString().replaceAll("-", "") : fileName);
            try {
                gridFSInputFile.save();
            } catch (Exception e) {
                e.printStackTrace();
                if (gridFSDBFile != null)
                    gridFSDBFile.save();
                throw new DatabaseException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }


    }

    @Override
    public String findUserImageFileNameById(ObjectId id) throws DatabaseException {
        try {
            GridFS gridfs = new GridFS(DbConnection.bulkDatastore().getDB());
            GridFSDBFile gridFSDBFile = gridfs.find(id);
            if (gridFSDBFile != null)
                return gridFSDBFile.getFilename();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public byte[] findUserImageByFileName(String fileName) throws DatabaseException {
        try {
            GridFS gridfs = new GridFS(DbConnection.bulkDatastore().getDB());
            GridFSDBFile gridFSDBFile = gridfs.findOne(fileName);
            if (gridFSDBFile != null)
                return IOUtils.toByteArray(gridFSDBFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        return null;
    }

    @Override
    public void updateUserEmail(String email, ObjectId id) throws DatabaseException {
        try {
            Query<User> query = DbConnection.datastore().find(User.class)
                    .field("id").equal(id);
            UpdateOperations<User> updateOperations = DbConnection.datastore().createUpdateOperations(User.class)
                    .set("email", email);
            DbConnection.datastore().update(query, updateOperations);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public User findUserByUserId(String nationalCode) throws DatabaseException {
        try {
            Query<IndividualCustomer> customerQuery = DbConnection.datastore().createQuery(IndividualCustomer.class).
                    field("identityCode").equal(nationalCode);
            Query<User> userQuery = DbConnection.datastore().createQuery(User.class);
            userQuery.criteria("customer").in(customerQuery.asKeyList());
            return userQuery.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }

    @Override
    public User findActivatedUserByCellNumber(String cellNumber) throws DatabaseException, UserNotFoundException {
        User user;
        try {
            Query<User> query = DbConnection.datastore().find(User.class);
            query.field("mobileNo").equal(cellNumber).field("isActive").equal(true);
             user = query.get();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        if(user == null)
            throw new UserNotFoundException();
        return user;
    }


}
