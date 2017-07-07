package xyz.homapay.hampay.core.servermock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
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

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class PaymentTest extends AbstractTestSuite {
    @Test
    public void testIndividualPaymentConfirm() throws Exception {

        Type requestType = new TypeToken<RequestMessage<IndividualPaymentConfirmRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createIndividualPaymentConfirmRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("IndividualPaymentConfirmFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<IndividualPaymentConfirmResponse>>() {
        }.getType();
        ResponseMessage<IndividualPaymentConfirmResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getFullName());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testIndividualPayment() throws Exception {

        Type requestType = new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createIndividualPaymentRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("IndividualPaymentFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType();
        ResponseMessage<IndividualPaymentResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testBusinessPaymentConfirm() throws Exception {

        Type requestType = new TypeToken<RequestMessage<BusinessPaymentConfirmRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createBusinessPaymentConfirmRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("BusinessPaymentConfirmFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<BusinessPaymentConfirmResponse>>() {
        }.getType();
        ResponseMessage<BusinessPaymentConfirmResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getFullName());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testBusinessPayment() throws Exception {

        Type requestType = new TypeToken<RequestMessage<BusinessPaymentRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createBusinessPaymentRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("BusinessPaymentFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<BusinessPaymentResponse>>() {
        }.getType();
        ResponseMessage<BusinessPaymentResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<IndividualPaymentConfirmRequest> createIndividualPaymentConfirmRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<IndividualPaymentConfirmRequest> message = new RequestMessage<IndividualPaymentConfirmRequest>();
        message.setRequestHeader(header);
        IndividualPaymentConfirmRequest request = new IndividualPaymentConfirmRequest();
        request.setRequestUUID("1234");
        request.setCellNumber("09124267712");

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<IndividualPaymentRequest> createIndividualPaymentRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<IndividualPaymentRequest> message = new RequestMessage<IndividualPaymentRequest>();
        message.setRequestHeader(header);
        IndividualPaymentRequest request = new IndividualPaymentRequest();
        request.setRequestUUID("1234");
        request.setCellNumber("09124267712");
        request.setAmount(200000L);
        request.setMessage("A dummy individual payment.");

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<BusinessPaymentConfirmRequest> createBusinessPaymentConfirmRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<BusinessPaymentConfirmRequest> message = new RequestMessage<BusinessPaymentConfirmRequest>();
        message.setRequestHeader(header);
        BusinessPaymentConfirmRequest request = new BusinessPaymentConfirmRequest();
        request.setRequestUUID("1234");
        request.setBusinessCode("12345");

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<BusinessPaymentRequest> createBusinessPaymentRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<BusinessPaymentRequest> message = new RequestMessage<BusinessPaymentRequest>();
        message.setRequestHeader(header);
        BusinessPaymentRequest request = new BusinessPaymentRequest();
        request.setRequestUUID("1234");
        request.setBusinessCode("12345");
        request.setMessage("This is a dummy business payment.");
        request.setAmount(500000L);

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }
}
