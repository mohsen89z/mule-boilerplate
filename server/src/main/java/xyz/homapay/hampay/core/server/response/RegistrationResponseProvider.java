package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.response.*;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class RegistrationResponseProvider {

    private PropertiesUtil propertiesUtil;

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public ResponseMessage<RegistrationEntryResponse> createEntrySuccessResponse(String requestUUID, String userIdToken) {

        ResponseMessage<RegistrationEntryResponse> responseMessage = new ResponseMessage<>();
        RegistrationEntryResponse response = new RegistrationEntryResponse();
        response.setUserIdToken(userIdToken);
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(requestUUID);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationSendSmsTokenResponse> createSendSmsTokenFailureResponse(String requestUUID) {

        ResponseMessage<RegistrationSendSmsTokenResponse> responseMessage = new ResponseMessage<>();
        RegistrationSendSmsTokenResponse response = new RegistrationSendSmsTokenResponse();
        response.setResultStatus(ResultStatus.SEND_SMS_FAILURE);
        response.setRequestUUID(requestUUID);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationSendSmsTokenResponse> createSendSmsTokenSuccessResponse(String requestUUID) {

        ResponseMessage<RegistrationSendSmsTokenResponse> responseMessage = new ResponseMessage<>();
        RegistrationSendSmsTokenResponse response = new RegistrationSendSmsTokenResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(requestUUID);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationVerifyMobileResponse> createVerifyMobileResponse(String requestUUID, Boolean isVerified) {

        ResponseMessage<RegistrationVerifyMobileResponse> responseMessage = new ResponseMessage<>();
        RegistrationVerifyMobileResponse response = new RegistrationVerifyMobileResponse();
        response.setIsVerified(isVerified);
        if (isVerified)
            response.setResultStatus(ResultStatus.SUCCESS);
        else
            response.setResultStatus(ResultStatus.REGISTRATION_INVALID_SMS_TOKEN);
        response.setRequestUUID(requestUUID);
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationCredentialsResponse> createCredentialEntrySuccessResponse(String requestUUID,
                                                                                                 List<ContactDTO> contactDTOs, String userIdToken) {

        ResponseMessage<RegistrationCredentialsResponse> responseMessage = new ResponseMessage<>();
        RegistrationCredentialsResponse response = new RegistrationCredentialsResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setContacts(contactDTOs);
        response.setRequestUUID(requestUUID);
        response.setUserIdToken(userIdToken);
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<RegistrationCredentialsResponse> createCredentialEntryFailureResponse(String requestUUID) {

        ResponseMessage<RegistrationCredentialsResponse> responseMessage = new ResponseMessage<>();
        RegistrationCredentialsResponse response = new RegistrationCredentialsResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(requestUUID);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<VerifyAccountResponse> createRegistrationVerifyAccountResponse(DepositAmountDTO depositDTO, String requestUUID) {
        ResponseMessage<VerifyAccountResponse> responseMessage = new ResponseMessage<>();
        VerifyAccountResponse service = new VerifyAccountResponse();
        service.setTransferMoneyComment(propertiesUtil.createVerifyComment(depositDTO));
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<VerifyTransferMoneyResponse> createVerifiedRegistrationTransferMoneyResponse(String requestUUID) {
        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<>();
        VerifyTransferMoneyResponse service = new VerifyTransferMoneyResponse();
        service.setIsVerified(true);
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<MobileRegistrationIdEntryResponse> createMobileRegistrationIdEntryResponse(String requestUUID) {
        ResponseMessage<MobileRegistrationIdEntryResponse> responseMessage = new ResponseMessage<>();
        MobileRegistrationIdEntryResponse service = new MobileRegistrationIdEntryResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<MobileRegistrationIdEntryResponse> createMobileRegistrationIdEntryAuthFailureResponse(String requestUUID) {
        ResponseMessage<MobileRegistrationIdEntryResponse> responseMessage = new ResponseMessage<>();
        MobileRegistrationIdEntryResponse service = new MobileRegistrationIdEntryResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }
}
