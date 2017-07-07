package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.request.*;
import xyz.homapay.hampay.common.core.model.response.*;
import xyz.homapay.hampay.common.core.model.response.dto.UserProfileDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class UserProfileResponseBuilder {


    public ResponseMessage<UserProfileResponse> createUserProfileFailureResponse(UserProfileRequest request) {

        ResponseMessage<UserProfileResponse> responseMessage = new ResponseMessage<UserProfileResponse>();
        UserProfileResponse response = new UserProfileResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setUserProfile(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<UserProfileResponse> createUserProfileSuccessResponse(UserProfileRequest request, String userId) {

        ResponseMessage<UserProfileResponse> responseMessage = new ResponseMessage<UserProfileResponse>();
        UserProfileResponse response = new UserProfileResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setUserProfile(getUserProfile(userId));

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ChangePassCodeResponse> createChangePassCodeFailureResponse(ChangePassCodeRequest request) {

        ResponseMessage<ChangePassCodeResponse> responseMessage = new ResponseMessage<ChangePassCodeResponse>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ChangePassCodeResponse> createChangePassCodeSuccessResponse(ChangePassCodeRequest request, String userId) {

        ResponseMessage<ChangePassCodeResponse> responseMessage = new ResponseMessage<ChangePassCodeResponse>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createChangeMemorableWordFailureResponse(ChangeMemorableWordRequest request) {

        ResponseMessage<ChangeMemorableWordResponse> responseMessage = new ResponseMessage<ChangeMemorableWordResponse>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createChangeMemorableWordSuccessResponse(ChangeMemorableWordRequest request, String userId) {

        ResponseMessage<ChangeMemorableWordResponse> responseMessage = new ResponseMessage<ChangeMemorableWordResponse>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    //Verify user response, converts user from limited to verified user.
    public ResponseMessage<VerifyAccountResponse> createVerifyAccountFailureResponse(VerifyAccountRequest request) {

        ResponseMessage<VerifyAccountResponse> responseMessage = new ResponseMessage<VerifyAccountResponse>();
        VerifyAccountResponse response = new VerifyAccountResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<VerifyAccountResponse> createVerifyAccountSuccessResponse(VerifyAccountRequest request, String userId) {

        ResponseMessage<VerifyAccountResponse> responseMessage = new ResponseMessage<VerifyAccountResponse>();
        VerifyAccountResponse response = new VerifyAccountResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setTransferMoneyComment("مبلغ 2141 ریال از حساب هم پى 8000459 به حساب شما 1823454328 واریز شد.لطفا جهت پیوستن به اعضاى VIP مبلغ 2141 را از حساب 1823454328 به حساب هم پى 8000459 واریز نمایید.");

        responseMessage.setService(response);
        return responseMessage;
    }

    //Verify transfer money response, after user transfers a specified amount to hampay bank account.
    public ResponseMessage<VerifyTransferMoneyResponse> createVerifyTransferMoneyFailureResponse(VerifyTransferMoneyRequest request) {

        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<VerifyTransferMoneyResponse>();
        VerifyTransferMoneyResponse response = new VerifyTransferMoneyResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setIsVerified(false);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<VerifyTransferMoneyResponse> createVerifyTransferMoneySuccessResponse(VerifyTransferMoneyRequest request, String userId) {

        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<VerifyTransferMoneyResponse>();
        VerifyTransferMoneyResponse response = new VerifyTransferMoneyResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setIsVerified(true);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ContactsHampayEnabledResponse> createContactsHampayEnabledFailureResponse(ContactsHampayEnabledRequest request) {

        ResponseMessage<ContactsHampayEnabledResponse> responseMessage = new ResponseMessage<ContactsHampayEnabledResponse>();
        ContactsHampayEnabledResponse response = new ContactsHampayEnabledResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setContacts(null);

        responseMessage.setService(response);
        return responseMessage;

    }

    public ResponseMessage<ContactsHampayEnabledResponse> createContactsHampayEnabledSuccessResponse(ContactsHampayEnabledRequest request) {

        ResponseMessage<ContactsHampayEnabledResponse> responseMessage = new ResponseMessage<ContactsHampayEnabledResponse>();
        ContactsHampayEnabledResponse response = new ContactsHampayEnabledResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setContacts(getHampayEnabledContacts(request.getContacts()));

        responseMessage.setService(response);
        return responseMessage;

    }

    private UserProfileDTO getUserProfile(String userId) {
        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setTitle("Mr.");
        userProfile.setAccountNumber("182556005645");
        userProfile.setBankName("بانک تجارت");
        userProfile.setFullName("هومن امينی");
        userProfile.setCellNumber("09129479928");
        userProfile.setVerificationStatus(UserVerificationStatus.DELEGATED);
        userProfile.setLastLoginDate(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        userProfile.setMinXferAmount(2000L);
        userProfile.setMaxXferAmount(5000L);

        List<ContactDTO> selectedContacts = new ArrayList<ContactDTO>();

        ContactDTO contact1 = new ContactDTO();
        contact1.setCellNumber("09121111111");
        contact1.setDisplayName("هم پی يار تجارت");
        selectedContacts.add(contact1);

        ContactDTO contact2 = new ContactDTO();
        contact2.setCellNumber("09123333333");
        contact2.setDisplayName("مجيد زمانی");
        selectedContacts.add(contact2);

        ContactDTO contact3 = new ContactDTO();
        contact3.setCellNumber("09124444444");
        contact3.setDisplayName("مونا حاج علی اصغر");
        selectedContacts.add(contact3);

        ContactDTO contact4 = new ContactDTO();
        contact4.setCellNumber("09125555555");
        contact4.setDisplayName("پيام افضلی");
        selectedContacts.add(contact4);


        userProfile.setSelectedContacts(selectedContacts);

        return userProfile;
    }

    private List<ContactDTO> getHampayEnabledContacts(List<ContactDTO> contacts) {

        if (contacts == null)
            return null;

        List<ContactDTO> hampayEnabledContacts = new ArrayList<ContactDTO>();
        for (int i = 0; i < contacts.size(); i++) {
            if (i % 2 == 0) {
                hampayEnabledContacts.add(contacts.get(i));
            }
        }

        return hampayEnabledContacts;
    }

    public ResponseMessage<GetUserIdTokenResponse> createGetUserIdTokenSuccessResponse(GetUserIdTokenRequest request){
        ResponseMessage<GetUserIdTokenResponse> responseMessage = new ResponseMessage<>();
        GetUserIdTokenResponse service = new GetUserIdTokenResponse();
        service.setUserIdToken("0934850394850656");
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UnlinkUserResponse> createUnlinkUserSuccessResponse(UnlinkUserRequest request){
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        UnlinkUserResponse service = new UnlinkUserResponse();
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }
}

