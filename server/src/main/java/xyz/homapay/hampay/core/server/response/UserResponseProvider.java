package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.response.*;
import xyz.homapay.hampay.common.core.model.response.dto.UserProfileDTO;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Contact;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;
import xyz.homapay.hampay.core.server.helper.Util;
import xyz.homapay.hampay.core.server.service.AccountService;
import xyz.homapay.hampay.core.server.service.UserService;

import java.util.*;

/**
 * Created by Ebrahim Pasbani.
 */
public class UserResponseProvider {

    private PropertiesUtil propertiesUtil;
    private UserService userService;
    private AccountService accountService = new AccountService();
    private static final int RECENT_CONTACT_NUMBERS = 3;

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public ResponseMessage<VerifyAccountResponse> createAuthenticationFailureVerifyAccountResponse(String requestUUID) {
        ResponseMessage<VerifyAccountResponse> responseMessage = new ResponseMessage<>();
        VerifyAccountResponse service = new VerifyAccountResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<GetUserIdTokenResponse> createAuthFailureGetUserIdTokenResponse(String requestUUID) {
        ResponseMessage<GetUserIdTokenResponse> responseMessage = new ResponseMessage<>();
        GetUserIdTokenResponse service = new GetUserIdTokenResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<VerifyAccountResponse> createVerifyAccountResponse(DepositAmountDTO depositDTO, String requestUUID) {
        ResponseMessage<VerifyAccountResponse> responseMessage = new ResponseMessage<>();
        VerifyAccountResponse service = new VerifyAccountResponse();
        service.setTransferMoneyComment(propertiesUtil.createVerifyComment(depositDTO));
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<VerifyTransferMoneyResponse> createTransferMoneyResponse(String requestUUID) {
        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        VerifyTransferMoneyResponse service = new VerifyTransferMoneyResponse();
        service.setIsVerified(true);
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<VerifyTransferMoneyResponse> createAuthenticationFailureVerifyTransferMoneyResponse(String requestUUID) {
        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        VerifyTransferMoneyResponse service = new VerifyTransferMoneyResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UserProfileResponse> createProfileResponse(String requestUUID, User user) throws DatabaseException {
        ResponseMessage<UserProfileResponse> responseMessage = new ResponseMessage<>();
        UserProfileResponse service = new UserProfileResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setUserProfile(createUserProfileDTO(user));
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<GetUserIdTokenResponse> createGetUserIdTokenResponse(String requestUUID, User user) throws DatabaseException {
        ResponseMessage<GetUserIdTokenResponse> responseMessage = new ResponseMessage<>();
        GetUserIdTokenResponse service = new GetUserIdTokenResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setUserIdToken(user.getUserIdToken());
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UserProfileResponse> createAuthFailureUserProfileResponse(String requestUUID) throws DatabaseException {
        ResponseMessage<UserProfileResponse> responseMessage = new ResponseMessage<>();
        UserProfileResponse service = new UserProfileResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public UserProfileDTO createUserProfileDTO(User user) throws DatabaseException {
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setAccountNumber(user.getCustomer().getDefaultAccount().getAccountNumber());
        userProfileDTO.setBankName(user.getCustomer().getDefaultAccount().getBank().getName());
        userProfileDTO.setCellNumber(user.getMobileNo());
        userProfileDTO.setFullName(user.getCustomer().getName());
        userProfileDTO.setLastLoginDate(user.getLastLoginDate());
        userProfileDTO.setTitle(user.getCustomer().getDisplayName());
        userProfileDTO.setVerificationStatus(user.getVerificationStatus());
        userProfileDTO.setSelectedContacts(createContactDTOList(user));
        userProfileDTO.setUserImageId(userService.findUserImageFileNameById(user.getId()));
        userProfileDTO.setMinXferAmount(propertiesUtil.getMinimumUserTransferAmount());
        userProfileDTO.setMaxXferAmount(propertiesUtil.getMaximumUserTransferAmount());
        return userProfileDTO;
    }


    private List<ContactDTO> createContactDTOList(User user) throws DatabaseException {
        ArrayList<ContactDTO> contactDTOList = new ArrayList<>();
        contactDTOList.add(0, getHampayYarContact(user.getCustomer().getDefaultAccount().getBank().getCode()));
        contactDTOList.addAll(getIndividualContacts(user));
        return contactDTOList;
    }

    private List<ContactDTO> getIndividualContacts(User user) throws DatabaseException {
        Set<ContactDTO> contactDTOSet = new HashSet<>(RECENT_CONTACT_NUMBERS);
        if (user.getCustomer().getContacts() != null) {
            contactDTOSet.addAll(getRecentTransactionsContact(user));
            if (contactDTOSet.size() < RECENT_CONTACT_NUMBERS && user.getCustomer().getContacts().size() != contactDTOSet.size())
                getRemainedContactDTOs(user, contactDTOSet);

        }
        return new ArrayList<>(contactDTOSet);
    }

    private void getRemainedContactDTOs(User user, Set<ContactDTO> contactDTOs) throws DatabaseException {
        Collection<Contact> contacts = user.getCustomer().getContacts().values();
        int remains = RECENT_CONTACT_NUMBERS - contactDTOs.size();
        if (contacts.size() - contactDTOs.size() <= remains)
            addAllContactDTOs(contacts, contactDTOs);
        else {
            int j = 0;
            for (int i = 1; i <= remains; i++) {
                j++;
                try {
                    if (!contactDTOs.add(getRandomContact(contacts)))
                        i--;
                } catch (UserNotFoundException ignored) {
                    i--;
                }
                if (j >= 50)
                    break;
            }
        }
    }

    private List<ContactDTO> getRecentTransactionsContact(User user) throws DatabaseException {
        List<ContactDTO> contactDTOs = new ArrayList<>(RECENT_CONTACT_NUMBERS);
        Collection<Contact> contacts = user.getCustomer().getContacts().values();
        List<Account> recentTransactionsAccount = accountService.getRecentTransactionAccountsByCustomerId(user.getCustomer().getId(), RECENT_CONTACT_NUMBERS);
        for (Account recentTransactionAccount : recentTransactionsAccount) {
            String phoneNumber = recentTransactionAccount.getCustomer().getPhoneNumber();
            for (Contact contact : contacts) {
                if (phoneNumber.equals(contact.getCellNumber()))
                    try {
                        contactDTOs.add(createContactDTO(contact));
                    } catch (UserNotFoundException ignored) {
                    }
            }
        }
        return contactDTOs;
    }

    private void addAllContactDTOs(Collection<Contact> contacts, Set<ContactDTO> contactDTOs) throws DatabaseException {
        for (Contact contact : contacts) {
            try {
                contactDTOs.add(createContactDTO(contact));
            } catch (UserNotFoundException ignored) {

            }
        }
    }

    private ContactDTO getRandomContact(Collection<Contact> contacts) throws UserNotFoundException, DatabaseException {
        return createContactDTO((Contact) contacts.toArray()[Util.getRandomNumberInRange(0, contacts.size() - 1)]);
    }

    private ContactDTO createContactDTO(Contact contact) throws UserNotFoundException, DatabaseException {
        User user = userService.findActivatedUserByCellNumber(contact.getCellNumber());
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setCellNumber(contact.getCellNumber());
        contactDTO.setDisplayName(contact.getDisplayName());
        contactDTO.setUserVerificationStatus(user.getVerificationStatus());
        contactDTO.setContactImageId(userService.findUserImageFileNameById(user.getId()));
        return contactDTO;
    }

    private ContactDTO getHampayYarContact(String bankCode) {
        ContactDTO contactDTO = new ContactDTO();
        if (propertiesUtil.getTejaratBankCode().equals(bankCode)) {
            contactDTO.setCellNumber(propertiesUtil.getTejaratHampayYarNumber());
            contactDTO.setDisplayName(propertiesUtil.getTejaratHampayYarDisplayName());
        } else if (propertiesUtil.getMiddleEastBankCode().equals(bankCode)) {
            contactDTO.setCellNumber(propertiesUtil.getMiddleEastHampayYarNumber());
            contactDTO.setDisplayName(propertiesUtil.getMiddleEastHampayYarDisplayName());
        }
        contactDTO.setUserVerificationStatus(UserVerificationStatus.DELEGATED);
        return contactDTO;
    }


    public ResponseMessage<UploadImageResponse> createAuthFailureUploadImageResponse(String requestUUID) {
        ResponseMessage<UploadImageResponse> responseMessage = new ResponseMessage<>();
        UploadImageResponse service = new UploadImageResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UploadImageResponse> createUploadImageResponse(String requestUUID) {
        ResponseMessage<UploadImageResponse> responseMessage = new ResponseMessage<>();
        UploadImageResponse service = new UploadImageResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<ChangeEmailResponse> createAuthFailureChangeEmailResponse(String requestUUID) {
        ResponseMessage<ChangeEmailResponse> responseMessage = new ResponseMessage<>();
        ChangeEmailResponse service = new ChangeEmailResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<ChangeEmailResponse> createInvalidPasscodeForChangeEmailResponse(String requestUUID) {
        ResponseMessage<ChangeEmailResponse> responseMessage = new ResponseMessage<>();
        ChangeEmailResponse service = new ChangeEmailResponse();
        service.setResultStatus(ResultStatus.INVALID_PASSCODE);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<ChangeEmailResponse> createChangeEmailResponse(String requestUUID) {
        ResponseMessage<ChangeEmailResponse> responseMessage = new ResponseMessage<>();
        ChangeEmailResponse service = new ChangeEmailResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }


}
