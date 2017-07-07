package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.ChangeMemorableWordRequest;
import xyz.homapay.hampay.common.core.model.request.ChangePassCodeRequest;
import xyz.homapay.hampay.common.core.model.request.RegistrationConfirmUserDataRequest;
import xyz.homapay.hampay.common.core.model.request.RegistrationFetchUserDataRequest;
import xyz.homapay.hampay.common.core.model.response.*;

import java.util.Date;

/**
 * Created by Ebrahim Pasbani.
 */
public class SecurityResponseProvider {
    public ResponseMessage<ChangePassCodeResponse> createAuthenticationFailureChangePassCodeResponse(String requestUUID) {
        ResponseMessage<ChangePassCodeResponse> message = new ResponseMessage<>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangePassCodeResponse> createFailedChangePassCodeResponse(String requestUUID) {
        ResponseMessage<ChangePassCodeResponse> message = new ResponseMessage<>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangePassCodeResponse> createInvalidPasscodeFailureResponseForChangePassCode(String requestUUID) {
        ResponseMessage<ChangePassCodeResponse> message = new ResponseMessage<>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.INVALID_PASSCODE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangePassCodeResponse> createSuccessChangePassCodeResponse(ChangePassCodeRequest request) {
        ResponseMessage<ChangePassCodeResponse> message = new ResponseMessage<>();
        ChangePassCodeResponse response = new ChangePassCodeResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createFailedChangeMemorableWordResponse(String requestUUID) {
        ResponseMessage<ChangeMemorableWordResponse> message = new ResponseMessage<>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createAuthenticationFailureChangeMemorableWordResponse(String requestUUID) {
        ResponseMessage<ChangeMemorableWordResponse> message = new ResponseMessage<>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }


    public ResponseMessage<ChangeMemorableWordResponse> createInvalidMemorableWordForChangeMemorableWordResponse(String requestUUID) {
        ResponseMessage<ChangeMemorableWordResponse> message = new ResponseMessage<>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.INVALID_MEMORABLE_WORD);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createInvalidPasscodeForChangeMemorableWordResponse(String requestUUID) {
        ResponseMessage<ChangeMemorableWordResponse> message = new ResponseMessage<>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.INVALID_PASSCODE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createSuccessChangeMemorableWordResponse(ChangeMemorableWordRequest request) {
        ResponseMessage<ChangeMemorableWordResponse> message = new ResponseMessage<>();
        ChangeMemorableWordResponse response = new ChangeMemorableWordResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        message.setService(response);
        return message;
    }

    public ResponseMessage<RegistrationFetchUserDataResponse> createFailedRegistrationFetchUserDataResponse(RegistrationFetchUserDataRequest request) {
        ResponseMessage<RegistrationFetchUserDataResponse> message = new ResponseMessage<>();
        RegistrationFetchUserDataResponse response = new RegistrationFetchUserDataResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        message.setService(response);
        return message;
    }

    public ResponseMessage<RegistrationFetchUserDataResponse> createRegistrationFetchUserDataResponse(RegistrationFetchUserDataRequest request, RegistrationFetchUserDataResponse response) {
        ResponseMessage<RegistrationFetchUserDataResponse> message = new ResponseMessage<>();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        message.setService(response);
        return message;
    }

    public ResponseMessage<RegistrationConfirmUserDataResponse> createFailedRegistrationConfirmUserDataResponse(RegistrationConfirmUserDataRequest request) {
        ResponseMessage<RegistrationConfirmUserDataResponse> message = new ResponseMessage<>();
        RegistrationConfirmUserDataResponse response = new RegistrationConfirmUserDataResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        message.setService(response);
        return message;
    }

    public ResponseMessage<RegistrationConfirmUserDataResponse> createSuccessRegistrationConfirmUserDataResponse(RegistrationConfirmUserDataRequest request, Date confirmDate) {
        RegistrationConfirmUserDataResponse response = new RegistrationConfirmUserDataResponse();
        response.setRequestUUID(request.getRequestUUID());
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setConfirmationDate(confirmDate);

        ResponseMessage<RegistrationConfirmUserDataResponse> message = new ResponseMessage<>();
        message.setService(response);
        return message;
    }

    public ResponseMessage<UnlinkUserResponse> createAuthenticationFailureUnlinkUserResponse(String requestUUID) {
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        UnlinkUserResponse service = new UnlinkUserResponse();
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UnlinkUserResponse> createInvalidPasscodeForUnlinkUserResponse(String requestUUID) {
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        UnlinkUserResponse service = new UnlinkUserResponse();
        service.setResultStatus(ResultStatus.INVALID_PASSCODE);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UnlinkUserResponse> createFailureUnlinkUserResponse(String requestUUID) {
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        UnlinkUserResponse service = new UnlinkUserResponse();
        service.setResultStatus(ResultStatus.FAILURE);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<UnlinkUserResponse> createSuccessUnlinkUserResponse(String requestUUID) {
        ResponseMessage<UnlinkUserResponse> responseMessage = new ResponseMessage<>();
        UnlinkUserResponse service = new UnlinkUserResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }


}
