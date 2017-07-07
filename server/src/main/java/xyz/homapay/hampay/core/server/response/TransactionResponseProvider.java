package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.TransactionListRequest;
import xyz.homapay.hampay.common.core.model.response.TransactionListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.TransactionDTO;

import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */
public class TransactionResponseProvider {

    public ResponseMessage<TransactionListResponse> createAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<TransactionListResponse> message = new ResponseMessage<>();
        TransactionListResponse response = new TransactionListResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<TransactionListResponse> createListByUserResponse(List<TransactionDTO> payload, TransactionListRequest request) {
        TransactionListResponse response;
        response = new TransactionListResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setTransactions(payload);
        response.setPageNumber(request.getPageNumber());
        response.setPageSize(request.getPageSize());

        ResponseMessage<TransactionListResponse> message = new ResponseMessage<>();
        message.setService(response);

        return message;
    }
}
