package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.TACAcceptResponse;
import xyz.homapay.hampay.common.core.model.response.TACResponse;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.TermsAndConditionsException;
import xyz.homapay.hampay.core.server.service.TACService;

/**
 * Created by sima on 7/2/15.
 */
public class TACResponseProvider {

    private TACService tacService;
    private UserResponseProvider userResponseProvider;

    public void setTacService(TACService tacService) {
        this.tacService = tacService;
    }

    public void setUserResponseProvider(UserResponseProvider userResponseProvider) {
        this.userResponseProvider = userResponseProvider;
    }

    public ResponseMessage<TACResponse> createShouldAcceptResponse(String requestUUID, User user) throws TermsAndConditionsException, DatabaseException {
        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        try {
            TACResponse service = new TACResponse();
            service.setRequestUUID(requestUUID);
            service.setResultStatus(ResultStatus.SUCCESS);
            service.setLastTACAcceptedDate(user.getTacAcceptDate());
//            service.setLastTACAcceptedVersion();
            service.setShouldAcceptTAC(true);
            service.setTac(tacService.getTACFileLatestVersionAsString());
            service.setUserIdToken(user.getUserIdToken());
            responseMessage.setService(service);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TermsAndConditionsException();
        }
        return responseMessage;
    }

    public ResponseMessage<TACResponse> createAlreadyAcceptedTACResponse(String requestUUID, User user) throws TermsAndConditionsException {
        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        try {
            TACResponse service = new TACResponse();
            service.setRequestUUID(requestUUID);
            service.setResultStatus(ResultStatus.SUCCESS);
            service.setLastTACAcceptedDate(user.getTacAcceptDate());
//            service.setLastTACAcceptedVersion();
            service.setShouldAcceptTAC(false);
            service.setUserIdToken(user.getUserIdToken());
            service.setUserProfile(userResponseProvider.createUserProfileDTO(user));
            responseMessage.setService(service);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TermsAndConditionsException();
        }
        return responseMessage;
    }

    public ResponseMessage<TACAcceptResponse> createTACAcceptResponse(String requestUUID, User user) throws TermsAndConditionsException {
        ResponseMessage<TACAcceptResponse> responseMessage = new ResponseMessage<>();
        try {
            TACAcceptResponse service = new TACAcceptResponse();
            service.setRequestUUID(requestUUID);
            service.setResultStatus(ResultStatus.SUCCESS);
            service.setUserProfile(userResponseProvider.createUserProfileDTO(user));
            responseMessage.setService(service);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TermsAndConditionsException();
        }
        return responseMessage;
    }


    public ResponseMessage<TACResponse> createAuthenticationFailureTacResponse(String requestUUID) {

        ResponseMessage<TACResponse> responseMessage = new ResponseMessage<>();
        TACResponse response = new TACResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        response.setShouldAcceptTAC(false);
        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<TACAcceptResponse> createAuthenticationFailureTACAcceptFailureResponse(String requestUUID) {

        ResponseMessage<TACAcceptResponse> responseMessage = new ResponseMessage<>();
        TACAcceptResponse response = new TACAcceptResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        responseMessage.setService(response);
        return responseMessage;
    }

}
