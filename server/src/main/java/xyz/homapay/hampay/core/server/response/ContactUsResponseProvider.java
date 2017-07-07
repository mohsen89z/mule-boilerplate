package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.ContactUsResponse;

/**
 * @author Siavash Mahmoudpour
 */
public class ContactUsResponseProvider {


    public ResponseMessage<ContactUsResponse> createContactUsResponse(String requestUUID, String emailAddress, String phoneNumber) {
        ResponseMessage<ContactUsResponse> responseMessage = new ResponseMessage<ContactUsResponse>();
        ContactUsResponse response = new ContactUsResponse();
        response.setEmailAddress(emailAddress);
        response.setPhoneNumber(phoneNumber);
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setRequestUUID(requestUUID);

        responseMessage.setService(response);
        return responseMessage;
    }

}
