package xyz.homapay.hampay.core.server.service.switchbay;

import xyz.homapay.hampay.common.switchbay.model.CustomerType;
import xyz.homapay.hampay.common.switchbay.model.SwitchResponseStatus;
import xyz.homapay.hampay.common.switchbay.model.response.AccountProfileResponse;
import xyz.homapay.hampay.common.switchbay.model.response.PaymentResponse;
import xyz.homapay.hampay.common.switchbay.model.response.VerifyTransactionResponse;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.exception.*;
import xyz.homapay.hampay.core.server.service.TransactionService;

/**
 * Created by sima on 7/22/15.
 */
public class SwitchResponseService {
    private TransactionService transactionService;

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void checkAccountProfileStatus(AccountProfileResponse accountProfileResponse) throws SwitchResponseException, CustomerIsNotIndividualException, NationalCodeNotBelongsToAccountException, InvalidAccountException {
        if (accountProfileResponse.getSwitchResponseStatus() == SwitchResponseStatus.NATIONAL_ID_NOT_BELONG_ACCOUNT)
            throw new NationalCodeNotBelongsToAccountException();
        if (accountProfileResponse.getSwitchResponseStatus() == SwitchResponseStatus.CUSTOMER_NOT_FOUND)
            throw new InvalidAccountException();
        if (accountProfileResponse.getSwitchResponseStatus() != SwitchResponseStatus.SUCCESS)
            throw new SwitchResponseException();
        if (accountProfileResponse.getSwitchResponseStatus() == SwitchResponseStatus.SUCCESS && accountProfileResponse.getCustomerType() != CustomerType.INDIVIDUAL_ACCOUNT)
            throw new CustomerIsNotIndividualException();
        if (accountProfileResponse.getName() != null)
            accountProfileResponse.setName(accountProfileResponse.getName().trim().replaceAll("([ ]{2,})", " "));
    }

    public void checkVerifyTransactionStatus(VerifyTransactionResponse verifyTransactionResponse) throws SwitchResponseException, SwitchVerificationFailureException {
        if (verifyTransactionResponse.getSwitchResponseStatus() == SwitchResponseStatus.TRANSACTION_NOT_FOUND)
            throw new SwitchVerificationFailureException();
        if (verifyTransactionResponse.getSwitchResponseStatus() != SwitchResponseStatus.SUCCESS)
            throw new SwitchResponseException();
    }

    public void updatePaymentTransactionStatus(PaymentResponse paymentResponse) throws DatabaseException, TransactionNotFoundException {
        Transaction transaction = transactionService.findTransactionByReferenceCode(paymentResponse.getTransactionId());
        if ((paymentResponse.getSwitchResponseStatus() != SwitchResponseStatus.SUCCESS) == (paymentResponse.getSwitchResponseStatus() != SwitchResponseStatus.SUCCESSFUL_BUT_SOURCE_LEG_COULD_NOT_TRANSFERRED)) {
            transaction.setTransactionStatus(Transaction.TransactionStatus.FAILURE);
            transaction.setRejectReason(paymentResponse.getSwitchResponseStatus());
        } else
            transaction.setTransactionStatus(Transaction.TransactionStatus.SUCCESS);
        updateTransaction(transaction);

    }

    public void updateTransaction(Transaction transaction) {
        try {
            transactionService.save(transaction);
        } catch (DatabaseException e) {
            e.printStackTrace();
            //todo What should we do in this critical situation
        }
    }
}
