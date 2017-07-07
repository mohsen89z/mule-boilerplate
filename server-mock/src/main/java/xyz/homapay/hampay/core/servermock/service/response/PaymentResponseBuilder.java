package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentRequest;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentResponse;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentResponse;

/**
 * @author Siavash Mahmoudpour
 */
public class PaymentResponseBuilder {

    public ResponseMessage<IndividualPaymentConfirmResponse> createIndividualPaymentConfirmFailureResponse(IndividualPaymentConfirmRequest request) {

        ResponseMessage<IndividualPaymentConfirmResponse> responseMessage = new ResponseMessage<IndividualPaymentConfirmResponse>();
        IndividualPaymentConfirmResponse response = new IndividualPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setCellNumber(null);
        response.setFullName(null);
        response.setBankName(null);

        responseMessage.setService(response);
        return responseMessage;

    }

    public ResponseMessage<IndividualPaymentConfirmResponse> createIndividualPaymentConfirmSuccessResponse(IndividualPaymentConfirmRequest request) {

        ResponseMessage<IndividualPaymentConfirmResponse> responseMessage = new ResponseMessage<IndividualPaymentConfirmResponse>();
        IndividualPaymentConfirmResponse response = new IndividualPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setCellNumber(request.getCellNumber());
        response.setFullName("هومن امينی");
        response.setBankName("بانک تجارت");
        responseMessage.setService(response);
        return responseMessage;

    }

    public ResponseMessage<IndividualPaymentResponse> createIndividualPaymentFailureResponse(IndividualPaymentRequest request) {

        ResponseMessage<IndividualPaymentResponse> responseMessage = new ResponseMessage<IndividualPaymentResponse>();
        IndividualPaymentResponse response = new IndividualPaymentResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<IndividualPaymentResponse> createIndividualPaymentSuccessResponse(IndividualPaymentRequest request) {

        ResponseMessage<IndividualPaymentResponse> responseMessage = new ResponseMessage<IndividualPaymentResponse>();
        IndividualPaymentResponse response = new IndividualPaymentResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setRefCode("12345678");

        responseMessage.setService(response);
        return responseMessage;
    }


    public ResponseMessage<BusinessPaymentConfirmResponse> createBusinessPaymentConfirmFailureResponse(BusinessPaymentConfirmRequest request) {

        ResponseMessage<BusinessPaymentConfirmResponse> responseMessage = new ResponseMessage<BusinessPaymentConfirmResponse>();
        BusinessPaymentConfirmResponse response = new BusinessPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());
        response.setBusinessCode(null);
        response.setFullName(null);

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<BusinessPaymentConfirmResponse> createBusinessPaymentConfirmSuccessResponse(BusinessPaymentConfirmRequest request) {

        ResponseMessage<BusinessPaymentConfirmResponse> responseMessage = new ResponseMessage<BusinessPaymentConfirmResponse>();
        BusinessPaymentConfirmResponse response = new BusinessPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setBusinessCode(request.getBusinessCode());
        response.setFullName("نشر چشمه");
        response.setBankName("بانک تجارت");

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<BusinessPaymentResponse> createBusinessPaymentFailureResponse(BusinessPaymentRequest request) {

        ResponseMessage<BusinessPaymentResponse> responseMessage = new ResponseMessage<BusinessPaymentResponse>();
        BusinessPaymentResponse response = new BusinessPaymentResponse();
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID(request.getRequestUUID());

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<BusinessPaymentResponse> createBusinessPaymentSuccessResponse(BusinessPaymentRequest request) {

        ResponseMessage<BusinessPaymentResponse> responseMessage = new ResponseMessage<BusinessPaymentResponse>();
        BusinessPaymentResponse response = new BusinessPaymentResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(request.getRequestUUID());
        response.setRefCode("12345678");

        responseMessage.setService(response);
        return responseMessage;
    }

}
