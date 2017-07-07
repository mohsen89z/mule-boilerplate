package xyz.homapay.hampay.core.server.response;

import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.request.ContactsHampayEnabledRequest;
import xyz.homapay.hampay.common.core.model.response.ContactsHampayEnabledResponse;

import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */
public class ContactResponseProvider {

    public ResponseMessage<ContactsHampayEnabledResponse> createAuthenticationFailureResponse(String requestUUID) {
        ResponseMessage<ContactsHampayEnabledResponse> message = new ResponseMessage<>();
        ContactsHampayEnabledResponse response = new ContactsHampayEnabledResponse();
        response.setResultStatus(ResultStatus.AUTHENTICATION_FAILURE);
        response.setRequestUUID(requestUUID);
        message.setService(response);
        return message;
    }

    public ResponseMessage<ContactsHampayEnabledResponse> createHampayEnabledResponse(List<ContactDTO> payload, ContactsHampayEnabledRequest request) {
        ContactsHampayEnabledResponse response;
        response = new ContactsHampayEnabledResponse();
        response.setResultStatus(ResultStatus.SUCCESS);
        response.setContacts(payload);
        response.setRequestUUID(request.getRequestUUID());

        ResponseMessage<ContactsHampayEnabledResponse> message = new ResponseMessage<>();
        message.setService(response);

        return message;
    }

}
