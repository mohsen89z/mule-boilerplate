package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessListRequest;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.request.BusinessSearchRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentConfirmResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;

import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */
public class BusinessResponseProvider {

    public ResponseMessage<BusinessListResponse> createAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<BusinessListResponse> message = new ResponseMessage<BusinessListResponse>();
        BusinessListResponse response = new BusinessListResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);

        return message;
    }

    public ResponseMessage<BusinessPaymentConfirmResponse> createBizPaymentConfirmAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<BusinessPaymentConfirmResponse> message = new ResponseMessage<>();
        BusinessPaymentConfirmResponse response = new BusinessPaymentConfirmResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<BusinessListResponse> createAuthenticationFailureSearchBusinessResponse(String requestUUID) {
        ResponseMessage<BusinessListResponse> message = new ResponseMessage<BusinessListResponse>();
        BusinessListResponse response = new BusinessListResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<BusinessListResponse> createAllBusinessResponse(List<BusinessDTO> payload, BusinessListRequest request) {
        BusinessListResponse ret = new BusinessListResponse();
        ret.setResultStatus(ResultStatus.SUCCESS);
        ret.setBusinesses(payload);
        ret.setPageSize(request.getPageSize());
        ret.setPageNumber(request.getPageNumber());
        ret.setRequestUUID(request.getRequestUUID());

        ResponseMessage<BusinessListResponse> message = new ResponseMessage<BusinessListResponse>();
        message.setService(ret);

        return message;
    }

    public ResponseMessage<BusinessListResponse> createSearchBusinessResponse(List<BusinessDTO> payload, BusinessSearchRequest request) {
        BusinessListResponse ret = new BusinessListResponse();
        ret.setResultStatus(ResultStatus.SUCCESS);
        ret.setBusinesses(payload);
        ret.setPageSize(request.getPageSize());
        ret.setPageNumber(request.getPageNumber());
        ret.setRequestUUID(request.getRequestUUID());
        ResponseMessage<BusinessListResponse> message = new ResponseMessage<BusinessListResponse>();
        message.setService(ret);
        return message;
    }

    public ResponseMessage<BusinessPaymentConfirmResponse> createBusinessPaymentConfirm(BusinessPaymentConfirmResponse response, BusinessPaymentConfirmRequest request) {
        response.setRequestUUID(request.getRequestUUID());
        ResponseMessage<BusinessPaymentConfirmResponse> message = new ResponseMessage<>();
        message.setService(response);
        return message;
    }

}
