package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.VerifyTransferMoneyResponse;

/**
 * Created by sima on 6/28/15.
 */
public class VerifyTransferMoneyResponseProvider {

    public ResponseMessage<VerifyTransferMoneyResponse> createVerifyTransferMoneyResponse(Boolean isVerified, String requestUUID) {
        ResponseMessage<VerifyTransferMoneyResponse> responseMessage = new ResponseMessage<VerifyTransferMoneyResponse>();
        VerifyTransferMoneyResponse service = new VerifyTransferMoneyResponse();
        service.setIsVerified(isVerified);
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRequestUUID(requestUUID);
        responseMessage.setService(service);
        return responseMessage;
    }

}
