package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentConfirmResponse;

/**
 * Created by Ebrahim Pasbani.
 */
public class IndividualCustomerResponseProvider {

    public ResponseMessage<IndividualPaymentConfirmResponse> createAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<IndividualPaymentConfirmResponse> message = new ResponseMessage<>();
        IndividualPaymentConfirmResponse response = new IndividualPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);

        return message;
    }

    public ResponseMessage<IndividualPaymentConfirmResponse> createIndividualPaymentConfirm(IndividualPaymentConfirmResponse response, IndividualPaymentConfirmRequest request) {
        response.setRequestUUID(request.getRequestUUID());
        ResponseMessage<IndividualPaymentConfirmResponse> message = new ResponseMessage<>();
        message.setService(response);
        return message;
    }

}
