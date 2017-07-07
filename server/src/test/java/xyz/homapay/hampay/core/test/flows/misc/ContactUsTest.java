package xyz.homapay.hampay.core.test.flows.misc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.ContactUsRequest;
import xyz.homapay.hampay.common.core.model.response.ContactUsResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class ContactUsTest extends AbstractTestSuite {

    @Test
    public void testContactUs() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Type requestType = new TypeToken<RequestMessage<ContactUsRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRequest(), requestType);

//        MuleEvent event = testEvent(createRequest());
        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("ContactUsFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<ContactUsResponse>>() {
        }.getType();
        ResponseMessage<ContactUsResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getEmailAddress());
        assertNotNull(response.getService().getPhoneNumber());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<ContactUsRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");


        RequestMessage<ContactUsRequest> message = new RequestMessage<ContactUsRequest>();
        message.setRequestHeader(header);
        ContactUsRequest request = new ContactUsRequest();
        request.setRequestUUID("1234");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

}
