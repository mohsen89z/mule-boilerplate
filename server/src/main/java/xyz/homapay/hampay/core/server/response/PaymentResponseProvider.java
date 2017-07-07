package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentResponse;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentResponse;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.CustomerNotFoundException;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.FeeChargeNotFoundException;
import xyz.homapay.hampay.core.server.service.BillingService;
import xyz.homapay.hampay.core.server.service.CustomerService;
import xyz.homapay.hampay.core.server.service.TransactionService;

/**
 * Created by Ebrahim Pasbani.
 */
public class PaymentResponseProvider {

    private CustomerService customerService = new CustomerService();
    private TransactionService transactionService;
    private BillingService billingService;

    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public ResponseMessage<BusinessPaymentResponse> createAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<BusinessPaymentResponse> message = new ResponseMessage<>();
        BusinessPaymentResponse response = new BusinessPaymentResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);

        return message;
    }

    public ResponseMessage<IndividualPaymentResponse> createIndividualAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<IndividualPaymentResponse> message = new ResponseMessage<>();
        IndividualPaymentResponse response = new IndividualPaymentResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<BusinessPaymentResponse> createBusinessPaymentResponse(String requestUUID, String referenceCode) {
        ResponseMessage<BusinessPaymentResponse> message = new ResponseMessage<>();
        BusinessPaymentResponse service = new BusinessPaymentResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setRefCode(referenceCode);
        message.setService(service);
        return message;
    }

    public ResponseMessage<IndividualPaymentResponse> createIndividualPaymentResponse(String requestUUID, String referenceCode) {
        ResponseMessage<IndividualPaymentResponse> message = new ResponseMessage<>();
        IndividualPaymentResponse service = new IndividualPaymentResponse();
        service.setRequestUUID(requestUUID);
        service.setRefCode(referenceCode);
        service.setResultStatus(ResultStatus.SUCCESS);
        message.setService(service);
        return message;
    }

    public ResponseMessage<IndividualPaymentConfirmResponse> createIndividualPaymentConfirmResponse(IndividualPaymentConfirmRequest request, User user)
            throws DatabaseException, CustomerNotFoundException, FeeChargeNotFoundException {
        ResponseMessage<IndividualPaymentConfirmResponse> responseMessage = new ResponseMessage<>();
        IndividualPaymentConfirmResponse service = new IndividualPaymentConfirmResponse();
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.SUCCESS);
        IndividualCustomer customer = customerService.findCustomerByPhoneNumber(request.getCellNumber());
        service.setBankName(customer.getDefaultAccount().getBank().getName());
        service.setCellNumber(customer.getPhoneNumber());
        service.setFullName(customer.getName());
        service.setFeeCharge(billingService.calculateFeeCharge(user.getUserGroup().getBillingGroup(), request.getAmount()));
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<IndividualPaymentConfirmResponse> createIndividualConfirmAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<IndividualPaymentConfirmResponse> responseMessage = new ResponseMessage<>();
        IndividualPaymentConfirmResponse service = new IndividualPaymentConfirmResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<BusinessPaymentConfirmResponse> createBusinessPaymentConfirmResponse(BusinessPaymentConfirmRequest request, Business business) {
        ResponseMessage<BusinessPaymentConfirmResponse> responseMessage = new ResponseMessage<>();
        BusinessPaymentConfirmResponse service = new BusinessPaymentConfirmResponse();
        service.setRequestUUID(request.getRequestUUID());
        service.setResultStatus(ResultStatus.SUCCESS);
        service.setBankName(business.getDefaultAccount().getBank().getName());
        service.setFullName(business.getName());
        service.setBusinessCode(request.getBusinessCode());
        responseMessage.setService(service);
        return responseMessage;
    }

    public ResponseMessage<BusinessPaymentConfirmResponse> createBusinessConfirmAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<BusinessPaymentConfirmResponse> responseMessage = new ResponseMessage<>();
        BusinessPaymentConfirmResponse service = new BusinessPaymentConfirmResponse();
        service.setRequestUUID(requestUUID);
        service.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        responseMessage.setService(service);
        return responseMessage;
    }

}
