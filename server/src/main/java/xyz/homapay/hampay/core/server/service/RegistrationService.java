package xyz.homapay.hampay.core.server.service;

import com.mongodb.DuplicateKeyException;
import org.apache.commons.lang.RandomStringUtils;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import xyz.homapay.hampay.common.core.model.dto.DeviceDTO;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.request.RegistrationCredentialsRequest;
import xyz.homapay.hampay.common.core.model.request.RegistrationEntryRequest;
import xyz.homapay.hampay.common.core.model.request.RegistrationVerifyMobileRequest;
import xyz.homapay.hampay.common.switchbay.model.response.AccountProfileResponse;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.common.data.dto.IdpUserDTO;
import xyz.homapay.hampay.core.common.data.dto.SupportedBanks;
import xyz.homapay.hampay.core.common.data.model.*;
import xyz.homapay.hampay.core.common.exception.*;
import xyz.homapay.hampay.core.server.dao.CustomerDao;
import xyz.homapay.hampay.core.server.dao.impl.CustomerDaoImpl;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;
import xyz.homapay.hampay.core.server.helper.Util;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithms;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithmsImpl;

import java.io.IOException;
import java.util.*;

/**
 * @author Siavash Mahmoudpour
 */
public class RegistrationService {

    private BankService bankService = new BankService();
    private DeviceService deviceService;
    private AccountService accountService = new AccountService();
    private UserService userService;
    private CustomerDao customerDao = new CustomerDaoImpl();
    private PropertiesUtil propertiesUtil;


    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    private VerificationHistoryService verificationHistoryService = new VerificationHistoryService();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public User checkDuplicateCustomer(RegistrationEntryRequest request) throws DatabaseException, UserLinksToOtherCellphoneException, CellNumberAlreadyBoundToAnotherUserException, UserInfoIsNotUnlinkedException {
        checkCellNumberValidity(request);
        User user = userService.findUserByUserId(request.getNationalCode());
        if (user == null)
            return null;
        checkBindingStatusValidity(request, user);
        return user;
    }

    private void checkBindingStatusValidity(RegistrationEntryRequest request, User user) throws UserLinksToOtherCellphoneException, UserInfoIsNotUnlinkedException {
        if (!user.getMobileNo().equals(request.getCellNumber()) && user.getBindingStatus() == User.BindingStatus.LINK &&
                user.getIsActive())
            throw new UserLinksToOtherCellphoneException();
        if (user.getMobileNo().equals(request.getCellNumber()) && user.getBindingStatus() != User.BindingStatus.UNLINK
                && user.getIsActive())
            throw new UserInfoIsNotUnlinkedException();
    }

    private void checkCellNumberValidity(RegistrationEntryRequest request) throws DatabaseException, CellNumberAlreadyBoundToAnotherUserException {
        List<User> otherUserList = userService.findAllActivedUsersByCellNumber(request.getCellNumber());
        if (otherUserList == null || otherUserList.size() == 0)
            return;
        for (User otherUser : otherUserList) {
            if (!otherUser.getUserId().equals(request.getNationalCode()) && otherUser.getBindingStatus() == User.BindingStatus.LINK)
                throw new CellNumberAlreadyBoundToAnotherUserException();
        }
    }

    public String createUser(RegistrationEntryRequest request, AccountProfileResponse accountProfile) throws InvalidBankCodeException {

        String userIdToken = null;
        try {

//            IndividualCustomer currentCustomer = checkDuplicateCustomer(request);
//            if( currentCustomer != null ) {
//                currentCustomer.setFullPersianName(accountProfile.getName());
//                //Update current customer
//            }

            UserDevice device = new UserDevice();
            setDeviceValues(device, request);
            Key<UserDevice> deviceKey = DbConnection.datastore().save(device);

            Account account = new Account();
            account.setAccountNumber(request.getAccountNumber());
            account.setBank(bankService.getBankByCodeFromCachedList(request.getBankCode()));

            DbConnection.datastore().save(account);
            //Key<Account> accountKey = DbConnection.datastore().save(account);
            //account = DbConnection.datastore().getByKey(Account.class, accountKey);

            User user = new User();
            user.setMobileNo(request.getCellNumber());
            user.setEmail(request.getEmail());
            user.setUserId(request.getNationalCode());
            user.setRegistrationDate(new Date());
            user.setRegistrationExpiryDate(Util.addDayToDate(new Date(), 2));
            userIdToken = UUID.randomUUID().toString();
            user.setUserIdToken(userIdToken);
            user.setVerificationStatus(UserVerificationStatus.UNVERIFIED);
            user.setRegistrationStep(User.RegistrationStep.ENTRY_PASSED);
//            device.setUser(user);

            device = DbConnection.datastore().getByKey(UserDevice.class, deviceKey);
            List<UserDevice> devices = new ArrayList<>();
            devices.add(device);
            user.setDevices(devices);

            DbConnection.datastore().save(user);
            //Key<User> userKey = DbConnection.datastore().save(user);
            //user = DbConnection.datastore().getByKey(User.class, userKey);

//            DbConnection.datastore().save(user);

//            UpdateOperations updateOperations = DbConnection.datastore().createUpdateOperations(UserDevice.class).set("user", user);
//            DbConnection.datastore().update(device, updateOperations);

            device.setUser(user);
            DbConnection.datastore().save(device);

            List<User> users = new ArrayList<>();
            users.add(user);

            IndividualCustomer customer = new IndividualCustomer();
            customer.setPhoneNumber(request.getCellNumber());
            customer.setIdentityCode(request.getNationalCode());

            customer.setUsers(users);

            customer.setDefaultAccount(account);
            customer.setName(accountProfile.getName());
            customer.getAccounts().add(account);

            DbConnection.datastore().save(customer);
            //customer = DbConnection.datastore().getByKey(IndividualCustomer.class, customerKey);
            user.setCustomer(customer);
            user.setBindingStatus(User.BindingStatus.UNLINK);
            user.setLinkedNC(null);
            user.setUserGroup(userService.getDefaultUserGroup());
            user.setTacAcceptDate(new Date());
            DbConnection.datastore().save(user);

            account.setCustomer(customer);
            DbConnection.datastore().save(account);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return userIdToken;
    }

    private void setDeviceValues(UserDevice device, RegistrationEntryRequest request) {
        device.setImei(request.getDeviceDTO().getImei());
        device.setImsi(request.getDeviceDTO().getImsi());
        device.setSimcardSerial(request.getDeviceDTO().getSimcardSerial());
        device.setDeviceModel(request.getDeviceDTO().getDeviceModel());
        device.setDeviceAPI(request.getDeviceDTO().getDeviceAPI());
        device.setOsVersion(request.getDeviceDTO().getOsVersion());
        device.setDisplaySize(request.getDeviceDTO().getDisplaySize());
        device.setManufacture(request.getDeviceDTO().getManufacture());
        device.setBrand(request.getDeviceDTO().getBrand());
        device.setCpu_abi(request.getDeviceDTO().getCpu_abi());
        device.setNetworkOperatorName(request.getDeviceDTO().getNetworkOperatorName());
        device.setDisplayMetrics(request.getDeviceDTO().getDisplayMetrics());
        device.setSimState(request.getDeviceDTO().getSimState());
        device.setAndroidId(request.getDeviceDTO().getAndroidId());
        device.setLocale(request.getDeviceDTO().getLocale());
        device.setUserLocation(request.getDeviceDTO().getUserLocation());
        device.setMacAddress(request.getDeviceDTO().getMacAddress());
        device.setIsActive(false);
        if (request.getDeviceDTO().getOsName() == DeviceDTO.OSName.ANDROID)
            device.setOsName(OSName.ANDROID);
        else
            device.setOsName(OSName.IOS);

    }

    public String overwriteUser(RegistrationEntryRequest request, AccountProfileResponse accountProfile) throws InvalidBankCodeException, DatabaseException {
        try {
            User oldUser = userService.findUserByNationalCode(request.getNationalCode());
            for (UserDevice userDevice : oldUser.getDevices()) {
                overwriteDevice(userDevice, request);
            }
            overwriteAccount(oldUser.getCustomer().getDefaultAccount(), request);
            overwriteUser(oldUser, request);
            overwriteIndividualCustomer(oldUser.getCustomer(), request, accountProfile.getName());
            return oldUser.getUserIdToken();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return createUser(request, accountProfile);
    }


    private void overwriteDevice(UserDevice userDevice, RegistrationEntryRequest request) throws DatabaseException {
        userDevice.setActivationDate(null);
        userDevice.setDeviceId(null);
        userDevice.setInstallationToken(null);
        userDevice.setAppVersion(null);
        setDeviceValues(userDevice, request);
        deviceService.updateUserDevice(userDevice);
    }

    private void overwriteAccount(Account account, RegistrationEntryRequest request) throws InvalidBankCodeException, DatabaseException {
        account.setAccountNumber(request.getAccountNumber());
        account.setBank(bankService.getBankByCodeFromCachedList(request.getBankCode()));
        ObjectId customerId = account.getCustomer().getId();
        account.setCustomer(new IndividualCustomer());
        account.getCustomer().setId(customerId);
        accountService.updateAccount(account);
    }

    private void overwriteUser(User user, RegistrationEntryRequest request) throws DatabaseException {
        user.setMobileNo(request.getCellNumber());
        user.setEmail(request.getEmail());
        user.setUserId(request.getNationalCode());
        user.setRegistrationDate(new Date());
        user.setRegistrationExpiryDate(Util.addDayToDate(new Date(), 2));
        user.setUserIdToken(UUID.randomUUID().toString());
        user.setVerificationStatus(UserVerificationStatus.UNVERIFIED);
        user.setRegistrationStep(User.RegistrationStep.ENTRY_PASSED);
        user.setBindingStatus(User.BindingStatus.UNLINK);
        user.setLinkedNC(null);
        user.setUserGroup(userService.getDefaultUserGroup());
        user.setIsActive(false);
        user.setActivationDate(null);
        user.setRecentLoginDate(null);
        user.setLastLoginDate(null);
        user.setSmsToken(null);
        user.setTacAcceptDate(new Date());
        userService.updateUser(user);
    }

    private void overwriteIndividualCustomer(IndividualCustomer customer, RegistrationEntryRequest request, String fullPersianName) throws DatabaseException {
        for (Account account : customer.getAccounts()) {
            if (!account.equals(customer.getDefaultAccount()))
                accountService.deleteAccount(account);
        }
        customer.setAccounts(new ArrayList<Account>(1));
        customer.getAccounts().add(customer.getDefaultAccount());
        customer.setPhoneNumber(request.getCellNumber());
        customer.setIdentityCode(request.getNationalCode());
        customer.setName(fullPersianName);
        customer.setContacts(null);
        customer.setFatherName(null);
        customer.setBirthPlace(null);
        customer.setBirthDate(null);
        customer.setFirstName(null);
        customer.setFullEnglishName(null);
        customer.setLastName(null);
        customerDao.updateCustomer(customer);
    }


    public User getUserByUserIdToken(String userIdToken) throws UserNotFoundException, DatabaseException {
        return userService.findUserByUserIdToken(userIdToken);
    }

    public String generateSmsToken(User user) throws RegistrationInvalidStepException, RegistrationDateExpiredException, SMSNotSentException {

        if (user == null || user.getDevices() == null || user.getDevices().size() == 0)
            throw new SMSNotSentException();

        if (user.getRegistrationStep() == null || !Util.getFirstSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();

        String imei = user.getDevices().get(0).getImei();

        Random random = new Random(imei.hashCode() ^ user.getMobileNo().hashCode() ^ new Date().hashCode());
        String smsToken = Integer.toString(random.nextInt(89999) + 10000);
        user.setSmsToken(smsToken);
        return smsToken;
    }

    public void updateUserToSendSMSTokenStep(User user) throws DatabaseException {
        user.setRegistrationStep(User.RegistrationStep.SMS_TOKEN_SENT);
        userService.updateUser(user);
    }

    public boolean verifyMobile(RegistrationVerifyMobileRequest request) throws RegistrationInvalidStepException, DatabaseException, UserNotFoundException, RegistrationDateExpiredException {
        User user = getUserByUserIdToken(request.getUserIdToken());

        if (user.getRegistrationStep() == null || !Util.getFirstSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();


        if (user.getSmsToken().equals(request.getSmsToken())) {
            user.setRegistrationStep(User.RegistrationStep.SMS_TOKEN_VERIFIED);
            userService.updateUser(user);
            return true;
        } else {
            return false;
        }
    }

    public DepositAmountDTO createDepositAmountDTO(User user) throws DatabaseException, UserNotFoundException {
        DepositAmountDTO depositDTO = new DepositAmountDTO();
        depositDTO.setAmount(generateDepositAmount());
        depositDTO.setUserAccount(user.getCustomer().getDefaultAccount().getAccountNumber());
        depositDTO.setHampayAccount(getHampayAccount(user.getCustomer().getDefaultAccount().getBank().getCode()));
        return depositDTO;
    }

    public DepositAmountDTO createDepositAmountDTOFromUserVerification(VerificationHistory verificationHistory, User user) throws DatabaseException, UserNotFoundException {
        DepositAmountDTO depositDTO = new DepositAmountDTO();
        depositDTO.setAmount(verificationHistory.getAmount());
        depositDTO.setUserAccount(verificationHistory.getAccountNumber());
        depositDTO.setHampayAccount(getHampayAccount(user.getCustomer().getDefaultAccount().getBank().getCode()));
        return depositDTO;
    }


    public void updateRegistrationStatusForAccountVerify(User user) throws DatabaseException {
        user.setRegistrationStep(User.RegistrationStep.DEPOSIT_AMOUNT_GENERATED);
        user.setVerificationStatus(UserVerificationStatus.PENDING_REVIEW);
        userService.updateUser(user);
    }

    public void checkRegistrationStatusForAccountVerification(User user) throws RegistrationInvalidStepException, RegistrationDateExpiredException {
        if (user.getRegistrationStep() == null || !Util.getThirdSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();
    }

    private String getHampayAccount(String bankCode) {
        if (bankCode.equals(SupportedBanks.TEJARAT.getCode()))
            return propertiesUtil.getTejaratAccount();
        else if (bankCode.equals(SupportedBanks.MIDDLE_EAST.getCode()))
            return propertiesUtil.getMiddleEastAccount();
        return null;
    }

    public void checkRegistrationStatusForXferVerification(User user) throws RegistrationInvalidStepException, RegistrationDateExpiredException {
        if (user.getRegistrationStep() == null || !Util.getThirdSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();
    }

    public void updateRegistrationStatusForVerifyXfer(User user, VerificationHistory verificationHistory) throws DatabaseException {
        user.setRegistrationStep(User.RegistrationStep.ACCOUNT_XFER_VERIFIED);
        user.setVerificationStatus(UserVerificationStatus.VERIFIED);
        verificationHistoryService.updateVerificationHistoryToSettled(verificationHistory);
        userService.updateUser(user);
    }

    private Integer generateDepositAmount() {
        return new SecurityAlgorithmsImpl().generateDepositAmount
                (propertiesUtil.getMinimumDepositAmount(), propertiesUtil.getMaximumDepositAmount());
    }

    public void checkStepForFetchUserData(User user) throws RegistrationInvalidStepException, RegistrationDateExpiredException {
        if (user.getRegistrationStep() == null || !Util.getSecondSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();

    }

    public void updateRegistrationStatusForFetchUserData(User user) throws DatabaseException {
        user.setRegistrationStep(User.RegistrationStep.USER_DATA_FETCHED);
        userService.updateUser(user);
    }

    public void checkStepForConfirmUserData(User user) throws RegistrationInvalidStepException, DatabaseException, UserNotFoundException, RegistrationDateExpiredException {

        if (user.getRegistrationStep() == null || !Util.getSecondSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();
    }

    public void updateRegistrationStatusForConfirmUserDate(User user) throws DatabaseException {
        user.setRegistrationStep(User.RegistrationStep.USER_DATA_CONFIRMED);
        userService.updateUser(user);
    }

    public IdpUserDTO createIdpUserDTO(RegistrationCredentialsRequest request) throws RegistrationInvalidStepException, DatabaseException, UserNotFoundException, RegistrationDateExpiredException {
        IdpUserDTO dto = new IdpUserDTO();

        User user = getUserByUserIdToken(request.getUserIdToken());

        if (user == null) {
            System.out.println("createIdpUserDTO, user is null...");
            return null;
        }

        if (user.getRegistrationStep() == null || !Util.getFourthSectionRegistrationSteps().contains(user.getRegistrationStep()))
            throw new RegistrationInvalidStepException();

        if (user.getRegistrationExpiryDate().before(new Date()))
            throw new RegistrationDateExpiredException();

        SecurityAlgorithms securityAlgorithms = new SecurityAlgorithmsImpl();
        String password = securityAlgorithms.generatePassword(request.getMemorableKey(), request.getPassCode(),
                request.getDeviceId(), request.getInstallationToken());

        dto.setUsername(user.getUserId());
        dto.setUserPassword(password);

        return dto;
    }

    public User activateUser(RegistrationCredentialsRequest request) throws DatabaseException, UserNotFoundException, UserInfoIsNotUnlinkedException {
        User user = getUserByUserIdToken(request.getUserIdToken());

        Date date = new Date();

        user.setIsActive(true);
        user.setBindingStatus(User.BindingStatus.LINK);
        user.setActivationDate(date);
        user.setRegistrationStep(User.RegistrationStep.USER_ACTIVATED);
        user.setIsActive(true);
        user.setUserIdToken(RandomStringUtils.random(16, "0123456789abcdefABCDEF"));
        user.setLinkedNC(new Long(user.getUserId()));
        if (user.getDevices() != null && user.getDevices().size() > 0) {
            UserDevice device = user.getDevices().get(0);
            device.setActivationDate(date);
            device.setIsActive(true);
            device.setDeviceId(request.getDeviceId());
            device.setInstallationToken(request.getInstallationToken());
            deviceService.updateUserDevice(device);
        }
        try {
            userService.updateUser(user);
        }catch (DuplicateKeyException e){
            e.printStackTrace();
            throw new UserInfoIsNotUnlinkedException();
        }
        return user;
    }

    public void saveRegistrationIdForUser(String deviceId, String registrationId, ObjectId userObjectId) throws DatabaseException, UserNotFoundException, DeviceNotFoundException {
        UserDevice userDevice = deviceService.findDeviceByDeviceId(deviceId, userObjectId);
        userDevice.setRegistrationId(registrationId);
        deviceService.updateUserDevice(userDevice);
    }
}

