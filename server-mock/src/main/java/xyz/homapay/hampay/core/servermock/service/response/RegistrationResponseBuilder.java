package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.request.*;
import xyz.homapay.hampay.common.core.model.response.*;

import java.util.*;

/**
 * @author Siavash Mahmoudpour
 */
public class RegistrationResponseBuilder {

    public ResponseMessage<RegistrationEntryResponse> createEntryFailureResponse(RegistrationEntryRequest request) {

        ResponseMessage<RegistrationEntryResponse> responseMessage = new ResponseMessage<>();
        RegistrationEntryResponse response = new RegistrationEntryResponse();
        response.setUserIdToken(null);
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationEntryResponse> createEntrySuccessResponse(RegistrationEntryRequest request) {

        ResponseMessage<RegistrationEntryResponse> responseMessage = new ResponseMessage<>();
        RegistrationEntryResponse response = new RegistrationEntryResponse();
        response.setUserIdToken(UUID.randomUUID().toString());
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationCredentialsResponse> createCredentialSuccessResponse(RegistrationCredentialsRequest request) {

        ResponseMessage<RegistrationCredentialsResponse> responseMessage = new ResponseMessage<>();
        RegistrationCredentialsResponse response = new RegistrationCredentialsResponse();
        response.setUserIdToken(UUID.randomUUID().toString());
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setUserIdToken("349850398");
        response.setContacts(createContactList());
        responseMessage.setService(response);
        return responseMessage;
    }

    private List<ContactDTO> createContactList() {
        List<ContactDTO> contactDTOs = new ArrayList<>(2);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setCellNumber("09125252282");
        contactDTO.setDisplayName("Sima");
        contactDTO.setUserVerificationStatus(UserVerificationStatus.VERIFIED);
        contactDTOs.add(contactDTO);
        ContactDTO contactDTO2 = new ContactDTO();
        contactDTO2.setCellNumber("09126157905");
        contactDTO2.setDisplayName("Amir");
        contactDTO2.setUserVerificationStatus(UserVerificationStatus.DELEGATED);
        contactDTOs.add(contactDTO2);
        return contactDTOs;
    }

    public ResponseMessage<RegistrationSendSmsTokenResponse> createSendSmsTokenFailureResponse(RegistrationSendSmsTokenRequest request) {

        ResponseMessage<RegistrationSendSmsTokenResponse> responseMessage = new ResponseMessage<>();
        RegistrationSendSmsTokenResponse response = new RegistrationSendSmsTokenResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationSendSmsTokenResponse> createSendSmsTokenSuccessResponse(RegistrationSendSmsTokenRequest request) {

        ResponseMessage<RegistrationSendSmsTokenResponse> responseMessage = new ResponseMessage<>();
        RegistrationSendSmsTokenResponse response = new RegistrationSendSmsTokenResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyMobileResponse> createVerifyMobileFailureResponse(RegistrationVerifyMobileRequest request) {

        ResponseMessage<RegistrationVerifyMobileResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyMobileResponse response = new RegistrationVerifyMobileResponse();
        response.setIsVerified(true);
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyMobileResponse> createVerifyMobileSuccessResponse(RegistrationVerifyMobileRequest request) {

        ResponseMessage<RegistrationVerifyMobileResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyMobileResponse response = new RegistrationVerifyMobileResponse();
        response.setIsVerified(true);
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationAccountInfoResponse> createAccountInfoFailureResponse(RegistrationAccountInfoRequest request) {

        ResponseMessage<RegistrationAccountInfoResponse> responseMessage = new ResponseMessage<>();
        RegistrationAccountInfoResponse response = new RegistrationAccountInfoResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setAccountDescription(null);
        response.setAmount(0);
        response.setComment(null);
        response.setDestinationAccountNo(null);
        response.setSourceAccountNo(null);
        response.setExpirationHours(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationAccountInfoResponse> createAccountInfoSuccessResponse(RegistrationAccountInfoRequest request) {

        ResponseMessage<RegistrationAccountInfoResponse> responseMessage = new ResponseMessage<>();
        RegistrationAccountInfoResponse response = new RegistrationAccountInfoResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setAccountDescription("Account Description");
        response.setAmount(1000);
        response.setComment("This is a comment");
        response.setDestinationAccountNo("100099909");
        response.setSourceAccountNo(request.getAccountNumber());
        response.setExpirationHours(2);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyAccountResponse> createVerifyAccountFailureResponse(RegistrationVerifyAccountRequest request) {

        ResponseMessage<RegistrationVerifyAccountResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyAccountResponse response = new RegistrationVerifyAccountResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyAccountResponse> createVerifyAccountSuccessResponse(RegistrationVerifyAccountRequest request) {
        ResponseMessage<RegistrationVerifyAccountResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyAccountResponse response = new RegistrationVerifyAccountResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setTransferMoneyComment("مبلغ 2141 ریال از حساب هم پى 8000459 به حساب شما 1823454328 واریز شد.لطفا جهت پیوستن به اعضاى VIP مبلغ 2141 را از حساب 1823454328 به حساب هم پى 8000459 واریز نمایید.");
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationFetchUserDataResponse> createFetchUserDataFailureResponse(RegistrationFetchUserDataRequest request) {
        ResponseMessage<RegistrationFetchUserDataResponse> responseMessage = new ResponseMessage<>();
        RegistrationFetchUserDataResponse response = new RegistrationFetchUserDataResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setAccountNumber(null);
        response.setCellNumber(null);
        response.setFulName(null);
        response.setNationalCode(null);
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyTransferMoneyResponse> createVerifyTransferMoneySuccessResponse(RegistrationVerifyTransferMoneyRequest request) {
        ResponseMessage<RegistrationVerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyTransferMoneyResponse service = new RegistrationVerifyTransferMoneyResponse();
        service.setIsVerified(true);
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyTransferMoneyResponse> createVerifyTransferMoneyFailureResponse(RegistrationVerifyTransferMoneyRequest request) {
        ResponseMessage<RegistrationVerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyTransferMoneyResponse service = new RegistrationVerifyTransferMoneyResponse();
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<RegistrationFetchUserDataResponse> createFetchUserDataSuccessResponse(RegistrationFetchUserDataRequest request) {
        ResponseMessage<RegistrationFetchUserDataResponse> responseMessage = new ResponseMessage<>();
        RegistrationFetchUserDataResponse response = new RegistrationFetchUserDataResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setNationalCode("0061357710");
        response.setFulName("هومن امينی");
        response.setCellNumber("09129479928");
        response.setAccountNumber("1823454328");

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationConfirmUserDataResponse> createConfirmUserDataFailureResponse(RegistrationConfirmUserDataRequest request) {

        ResponseMessage<RegistrationConfirmUserDataResponse> responseMessage = new ResponseMessage<>();
        RegistrationConfirmUserDataResponse response = new RegistrationConfirmUserDataResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setConfirmationDate(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationConfirmUserDataResponse> createConfirmUserDataSuccessResponse(RegistrationConfirmUserDataRequest request) {

        ResponseMessage<RegistrationConfirmUserDataResponse> responseMessage = new ResponseMessage<>();
        RegistrationConfirmUserDataResponse response = new RegistrationConfirmUserDataResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setConfirmationDate(new Date());

        responseMessage.setService(response);
        return responseMessage;
    }


    public ResponseMessage<RegistrationCredentialsResponse> createCredentialsFailureResponse(RegistrationCredentialsRequest request) {

        ResponseMessage<RegistrationCredentialsResponse> responseMessage = new ResponseMessage<>();
        RegistrationCredentialsResponse response = new RegistrationCredentialsResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationCredentialsResponse> createCredentialsSuccessResponse(RegistrationCredentialsRequest request) {

        ResponseMessage<RegistrationCredentialsResponse> responseMessage = new ResponseMessage<>();
        RegistrationCredentialsResponse response = new RegistrationCredentialsResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    private String createSMSCode(String imei, String cellNo) {
        Random random = new Random(imei.hashCode() ^ cellNo.hashCode() ^ new Date().hashCode());
        return Integer.toString(random.nextInt(89999) + 10000);
    }
}
