package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.ChangeMemorableWordRequest;
import xyz.homapay.hampay.common.core.model.request.ChangePassCodeRequest;
import xyz.homapay.hampay.common.core.model.response.ChangeMemorableWordResponse;
import xyz.homapay.hampay.common.core.model.response.ChangePassCodeResponse;

/**
 * Created by sima on 11/12/15.
 */
public class SecurityResponseBuilder {

    public ResponseMessage<ChangePassCodeResponse> createChangePassCodeSuccessResponse(ChangePassCodeRequest request){
        ResponseMessage<ChangePassCodeResponse> responseMessage = new ResponseMessage<>();
        ChangePassCodeResponse service = new ChangePassCodeResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(request.getRequestUUID());
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<ChangeMemorableWordResponse> createChangeMemWordSuccessResponse(ChangeMemorableWordRequest request){
        ResponseMessage<ChangeMemorableWordResponse> responseMessage = new ResponseMessage<>();
        ChangeMemorableWordResponse service = new ChangeMemorableWordResponse();
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(request.getRequestUUID());
        responseMessage.setService(service);
        return responseMessage;
    }


}
