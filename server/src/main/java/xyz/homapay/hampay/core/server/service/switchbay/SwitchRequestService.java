package xyz.homapay.hampay.core.server.service.switchbay;

import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.switchbay.model.Account;
import xyz.homapay.hampay.common.switchbay.model.request.AccountProfileRequest;
import xyz.homapay.hampay.common.switchbay.model.request.PaymentRequest;
import xyz.homapay.hampay.common.switchbay.model.request.VerifyTransactionRequest;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.common.data.dto.SupportedBanks;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.data.model.VerificationHistory;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;

import java.util.UUID;

/**
 * Created by Ebrahim Pasbani.
 */
public class SwitchRequestService {

    private PropertiesUtil propertiesUtil;

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public RequestMessage<PaymentRequest> createSwitchPaymentRequestForBusiness(User payer, Transaction trx, Business biz) {
        RequestMessage<PaymentRequest> message = new RequestMessage<>();

        PaymentRequest request = new PaymentRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setAmount(trx.getAmount());
        request.setNationalId(payer.getCustomer().getIdentityCode());

        Account account = new Account();
        account.setAccountNumber(biz.getDefaultAccount().getAccountNumber());
        account.setBankCode(biz.getDefaultAccount().getBank().getCode());
        request.setDestinationAccount(account);

        account = new Account();
        account.setAccountNumber(payer.getCustomer().getDefaultAccount().getAccountNumber());
        account.setBankCode(payer.getCustomer().getDefaultAccount().getBank().getCode());
        request.setSourceAccount(account);

        request.setTransactionId(trx.getReference());

        message.setService(request);

        RequestHeader header = new RequestHeader();
        header.setVersion("0.1-PA");
        header.setAuthToken("123");
        message.setRequestHeader(header);

        return message;
    }

    public RequestMessage<PaymentRequest> createSwitchPaymentRequestForIndividual(User payer, Transaction transaction) {
        RequestMessage<PaymentRequest> message = new RequestMessage<>();

        PaymentRequest request = new PaymentRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setAmount(transaction.getAmount());
        request.setNationalId(payer.getCustomer().getIdentityCode());
        request.setFeeCharge(transaction.getFeeCharge());

        Account account = new Account();
        account.setAccountNumber(transaction.getDestinationAccount().getAccountNumber());
        account.setBankCode(transaction.getDestinationAccount().getBank().getCode());
        request.setDestinationAccount(account);

        account = new Account();
        account.setAccountNumber(payer.getCustomer().getDefaultAccount().getAccountNumber());
        account.setBankCode(payer.getCustomer().getDefaultAccount().getBank().getCode());
        request.setSourceAccount(account);

        request.setTransactionId(transaction.getReference());

        message.setService(request);

        RequestHeader header = new RequestHeader();
        header.setVersion("0.1-PA");
        header.setAuthToken("283764827364");
        message.setRequestHeader(header);

        return message;
    }

    private RequestMessage<AccountProfileRequest> createSwitchHampayAccountProfileRequest(Business biz, String authToken) {
        RequestMessage<AccountProfileRequest> message = new RequestMessage<>();

        AccountProfileRequest request = new AccountProfileRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        Account account = new Account();
        account.setAccountNumber(biz.getDefaultAccount().getAccountNumber());
        account.setBankCode(biz.getDefaultAccount().getBank().getCode());
        request.setAccount(account);

        message.setService(request);

        RequestHeader header = new RequestHeader();
        header.setVersion("0.1-PA");
        header.setAuthToken(authToken);
        message.setRequestHeader(header);

        return message;
    }

    private RequestMessage<AccountProfileRequest> createSwitchHampayAccountProfileRequest(User user, String authToken) {
        RequestMessage<AccountProfileRequest> message = new RequestMessage<>();

        AccountProfileRequest request = new AccountProfileRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        Account account = new Account();
        account.setAccountNumber(user.getCustomer().getDefaultAccount().getAccountNumber());
        account.setBankCode(user.getCustomer().getDefaultAccount().getBank().getCode());
        request.setAccount(account);

        message.setService(request);

        RequestHeader header = new RequestHeader();
        header.setVersion("0.1-PA");
        header.setAuthToken(authToken);
        message.setRequestHeader(header);

        return message;
    }

    public RequestMessage<VerifyTransactionRequest> getSwitchVerifyTransactionRequestMessage(User user, VerificationHistory verificationHistory) {
        RequestMessage<VerifyTransactionRequest> remoteRequest = new RequestMessage<>();
        VerifyTransactionRequest service = new VerifyTransactionRequest();
        service.setAccount(new Account());
        service.getAccount().setAccountNumber(user.getCustomer().getDefaultAccount().getAccountNumber());
        service.getAccount().setBankCode(user.getCustomer().getDefaultAccount().getBank().getCode());
        service.setNationalId(user.getCustomer().getIdentityCode());
        service.setAmount(verificationHistory.getAmount().longValue());
        service.setStartTimeStamp(user.getRegistrationDate());
        service.setEndTimeStamp(user.getRegistrationExpiryDate());
        service.setRequestUUID(UUID.randomUUID().toString());
        RequestHeader header = new RequestHeader();
        //todo these should be fill by which values
        header.setAuthToken("9999");
        header.setVersion("1.0-PA");

        remoteRequest.setService(service);
        remoteRequest.setRequestHeader(header);
        return remoteRequest;
    }

    public RequestMessage<AccountProfileRequest> getAccountProfileRequestMessageFromSwitchByBankAndAccount(String bankCode, String accountNumber, String nationalCode) {
        AccountProfileRequest request = new AccountProfileRequest();
        Account account = new Account();
        account.setBankCode(bankCode);
        account.setAccountNumber(accountNumber);
        request.setAccount(account);
        request.setNationalCode(nationalCode);
        request.setRequestUUID(UUID.randomUUID().toString());

        RequestHeader header = new RequestHeader();
        header.setAuthToken("9999");
        header.setVersion("1.0-PA");

        RequestMessage<AccountProfileRequest> message = new RequestMessage<>();
        message.setRequestHeader(header);
        message.setService(request);

        return message;
    }

    public RequestMessage<PaymentRequest> getSwitchPaymentRequestMessageForRegistration(User user, DepositAmountDTO depositAmountDTO) {
        RequestMessage<PaymentRequest> requestMessage = new RequestMessage<>();
        PaymentRequest service = new PaymentRequest();
        service.setSourceAccount(new Account());
        if (SupportedBanks.MIDDLE_EAST.getCode().equals(user.getCustomer().getDefaultAccount().getBank().getCode()))
            service.getSourceAccount().setAccountNumber(propertiesUtil.getMiddleEastAccount());
        if (SupportedBanks.TEJARAT.getCode().equals(user.getCustomer().getDefaultAccount().getBank().getCode()))
            service.getSourceAccount().setAccountNumber(propertiesUtil.getTejaratAccount());
        service.getSourceAccount().setBankCode(user.getCustomer().getDefaultAccount().getBank().getCode());
        service.setDestinationAccount(new Account());
        service.getDestinationAccount().setAccountNumber(depositAmountDTO.getUserAccount());
        service.getDestinationAccount().setBankCode(user.getCustomer().getDefaultAccount().getBank().getCode());
        service.setTransactionId(UUID.randomUUID().toString());
        service.setAmount(depositAmountDTO.getAmount().longValue());
        service.setNationalId(user.getCustomer().getIdentityCode());
        service.setRequestUUID(UUID.randomUUID().toString());
        RequestHeader header = new RequestHeader();
        header.setAuthToken("9999");
        header.setVersion("1.0-PA");
        requestMessage.setService(service);
        requestMessage.setRequestHeader(header);
        return requestMessage;
    }

}
