package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.TransactionListRequest;
import xyz.homapay.hampay.common.core.model.response.TransactionListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.TransactionDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */
public class TransactionsResponseBuilder {


    public ResponseMessage<TransactionListResponse> createTransactionListFailureResponse(TransactionListRequest request) {

        ResponseMessage<TransactionListResponse> responseMessage = new ResponseMessage<TransactionListResponse>();
        TransactionListResponse response = new TransactionListResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setPageNumber(-1);
        response.setPageSize(-1);
        response.setTransactions(null);

        responseMessage.setService(response);
        return responseMessage;

    }

    public ResponseMessage<TransactionListResponse> createTransactionListSuccessResponse(TransactionListRequest request, String userId) {

        ResponseMessage<TransactionListResponse> responseMessage = new ResponseMessage<TransactionListResponse>();
        TransactionListResponse response = new TransactionListResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setPageNumber(request.getPageNumber());
        response.setPageSize(request.getPageSize());
        response.setTransactions(getTransactions(userId, request.getPageSize()));

        responseMessage.setService(response);
        return responseMessage;

    }


    private List<TransactionDTO> getTransactions(String userId, int pageSize) {
        List<TransactionDTO> transactions = new ArrayList<TransactionDTO>();

        for (int i = 0; i < pageSize; i++) {
            TransactionDTO trx = new TransactionDTO();
            trx.setBusinessCode(null);
            trx.setAmount(3200000L);
            trx.setMessage("Babate donge bilit!");
            trx.setPhoneNumber("09121234567");
            trx.setPersonName("John Smith");
            trx.setPersonType(TransactionDTO.PersonType.INDIVIDUAL);
            trx.setReference("123456");
            trx.setTransactionDate(new Date());
            trx.setTransactionStatus(TransactionDTO.TransactionStatus.SUCCESS);
            trx.setTransactionType(TransactionDTO.TransactionType.DEBIT);
            transactions.add(trx);
        }

//        TransactionDTO trx2 = new TransactionDTO();
//        trx2.setBusinessCode("1024");
//        trx2.setAmount(250000L);
//        trx2.setMessage("Just a message!");
//        trx2.setMobileNumber(null);
//        trx2.setPersonName("Mahak Institute");
//        trx2.setPersonType(TransactionDTO.PersonType.BUSINESS);
//        trx2.setPhoneNumber("88888888");
//        trx2.setReference("123457");
//        trx2.setTransactionDate(new Date());
//        trx2.setTransactionStatus(TransactionDTO.TransactionStatus.SUCCESS);
//        trx2.setTransactionType(TransactionDTO.TransactionType.DEBIT);
//        transactions.add(trx2);
//
//        TransactionDTO trx3 = new TransactionDTO();
//        trx3.setBusinessCode(null);
//        trx3.setAmount(150000L);
//        trx3.setMessage("pule nahare diruz!");
//        trx3.setMobileNumber(null);
//        trx3.setPersonName("John Locke");
//        trx3.setPersonType(TransactionDTO.PersonType.INDIVIDUAL);
//        trx3.setPhoneNumber(null);
//        trx3.setReference("123458");
//        trx3.setTransactionDate(new Date());
//        trx3.setTransactionStatus(TransactionDTO.TransactionStatus.SUCCESS);
//        trx3.setTransactionType(TransactionDTO.TransactionType.CREDIT);
//        transactions.add(trx3);


        return transactions;
    }
}
