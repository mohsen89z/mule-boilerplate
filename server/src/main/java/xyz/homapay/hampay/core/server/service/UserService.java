package xyz.homapay.hampay.core.server.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.bson.types.ObjectId;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.common.data.dto.SupportedBanks;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.UserGroup;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.RegistrationInvalidStepException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.server.dao.UserDao;
import xyz.homapay.hampay.core.server.dao.UserGroupDao;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;
import xyz.homapay.hampay.core.server.helper.Util;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithmsImpl;

import javax.naming.SizeLimitExceededException;
import java.util.List;
import java.util.Set;

/**
 * Created by Ebrahim Pasbani.
 */
public class UserService {

    private UserDao userDao;
    private PropertiesUtil propertiesUtil;
    private UserGroupDao userGroupDao;

    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByUserIdToken(String userIdToken) throws UserNotFoundException, DatabaseException {
        return userDao.findUserByUserIdToken(userIdToken);
    }

    public void updateUserVerificationStatusToVerified(String userTokenId) throws RegistrationInvalidStepException {
        userDao.updateUserVerificationStatusToVerified(userTokenId);
    }


    public void updateTACDateById(ObjectId id) {
        userDao.updateTACDateById(id);
    }

    public User updateLastAndRecentLoginDate(User user) throws UserNotFoundException, DatabaseException {
        return userDao.updateLastAndRecentLoginDate(user);
    }


    public User findActivatedUserByCellNumber(String cellNumber) throws DatabaseException, UserNotFoundException {
        return userDao.findActivatedUserByCellNumber(cellNumber);
    }

    public void updateUser(User user) throws DatabaseException {
        userDao.updateUser(user);
    }

    public User findUserByUserIdToken(String userIdToken) throws DatabaseException, UserNotFoundException {
        return userDao.findUserByUserIdToken(userIdToken);
    }

    public User findUserByNationalCode(String nationalCode) throws DatabaseException, UserNotFoundException {
        return userDao.findUserByNationalCode(nationalCode);
    }

    public List<User> findActivatedUserByCellNumber(Set<String> numbers) throws DatabaseException {
        return userDao.findActivatedUserByCellNumber(numbers);
    }

    public User findActivatedUserByUserId(String userId) throws DatabaseException, UserNotFoundException {
        return userDao.findActivatedUserByUserId(userId);
    }

    public DepositAmountDTO createDepositDTO(User user) throws UserNotFoundException, DatabaseException {
        DepositAmountDTO depositDTO = new DepositAmountDTO();
        depositDTO.setAmount(generateDepositAmount());
        depositDTO.setUserAccount(user.getCustomer().getDefaultAccount().getAccountNumber());
        depositDTO.setHampayAccount(getHampayAccount(user.getCustomer().getDefaultAccount().getBank().getCode()));
        return depositDTO;
    }

    private String getHampayAccount(String bankCode) {
        if (bankCode.equals(SupportedBanks.TEJARAT.getCode()))
            return propertiesUtil.getTejaratAccount();
        else if (bankCode.equals(SupportedBanks.MIDDLE_EAST.getCode()))
            return propertiesUtil.getMiddleEastAccount();
        return null;
    }

    private Integer generateDepositAmount() {
        return new SecurityAlgorithmsImpl().generateDepositAmount
                (propertiesUtil.getMinimumDepositAmount(), propertiesUtil.getMaximumDepositAmount());
    }

    public void updateUserVerificationStatus(User user) throws DatabaseException {
        user.setVerificationStatus(UserVerificationStatus.VERIFIED);
        userDao.updateUser(user);
    }

    public List<User> findAllActivedUsersByCellNumber(String cellNumber) throws DatabaseException{
        return userDao.findAllActivedUsersByCellNumber(cellNumber);
    }

    public void unlinkUser(User user) throws DatabaseException {
        user.setBindingStatus(User.BindingStatus.UNLINK);
        user.setLinkedNC(null);
        user.setRegistrationStep(User.RegistrationStep.USER_DEACTIVATED);
        user.setIsActive(false);
        userDao.updateUser(user);
    }

    public void linkUser(User user) throws DatabaseException {
        user.setBindingStatus(User.BindingStatus.LINK);
        user.setRegistrationStep(User.RegistrationStep.USER_ACTIVATED);
        userDao.updateUser(user);
    }

    public void insertImage(byte[] image, User user) throws DatabaseException, SizeLimitExceededException {
        if (image.length > (propertiesUtil.getMaxUserImageSize() * 1024))
            throw new SizeLimitExceededException();
        userDao.insertImage(image, user.getId());
    }

    public String findUserImageFileNameById(ObjectId Id) throws DatabaseException {
        return userDao.findUserImageFileNameById(Id);
    }

    public byte[] findImageByFileName(String fileName) throws DatabaseException {
        if (fileName != null)
            return userDao.findUserImageByFileName(fileName);
        return null;
    }

    public RequestMessage createRequestObjectToValidateAuthToken(String authToken) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setRequestHeader(new RequestHeader());
        requestMessage.getRequestHeader().setAuthToken(authToken);
        return requestMessage;
    }

    public UserGroup getDefaultUserGroup() throws DatabaseException {
        return userGroupDao.findDefaultUserGroup();
    }

    public void updateUserEmail(String email, User user) throws InvalidFormatException, DatabaseException {
        if (email == null || !Util.validateEmailFormat(email))
            throw new InvalidFormatException("Email format is invalid", email, String.class);
        if (!email.equals(user.getEmail()))
            userDao.updateUserEmail(email, user.getId());
    }

    public User findUserByUserId(String nationalCode) throws DatabaseException {
        return userDao.findUserByUserId(nationalCode);
    }
}
