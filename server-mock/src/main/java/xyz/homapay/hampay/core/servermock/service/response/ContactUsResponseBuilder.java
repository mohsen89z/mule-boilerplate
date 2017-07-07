package xyz.homapay.hampay.core.servermock.service.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.ContactUsResponse;

/**
 * @author Siavash Mahmoudpour
 */
public class ContactUsResponseBuilder {


    public ResponseMessage<ContactUsResponse> createContactUsSuccessResponse(String emailAddress, String phoneNumber) {
        ResponseMessage<ContactUsResponse> responseMessage = new ResponseMessage<ContactUsResponse>();
        ContactUsResponse response = new ContactUsResponse();
        response.setEmailAddress(emailAddress);
        response.setPhoneNumber(phoneNumber);
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID("");

        responseMessage.setService(response);
        return responseMessage;
    }

    public ResponseMessage<ContactUsResponse> createContactUsFailureResponse(String emailAddress, String phoneNumber) {
        ResponseMessage<ContactUsResponse> responseMessage = new ResponseMessage<ContactUsResponse>();
        ContactUsResponse response = new ContactUsResponse();
        response.setEmailAddress(emailAddress);
        response.setPhoneNumber(phoneNumber);
        response.setResultStatus(ResultStatus.FAILURE);
        response.setRequestUUID("");

        responseMessage.setService(response);
        return responseMessage;
    }

}
