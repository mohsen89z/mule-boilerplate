package xyz.homapay.hampay.core.servermock;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.DeviceDTO;
import xyz.homapay.hampay.common.core.model.request.*;
import xyz.homapay.hampay.common.core.model.response.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class RegistrationTest extends AbstractTestSuite {


    @Test
    public void testRegistrationEntry() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationEntryRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationEntryRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationEntryFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationEntryResponse>>() {
        }.getType();
        ResponseMessage<RegistrationEntryResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getUserIdToken());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationSendSmsToken() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationSendSmsTokenRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationSendSmsTokenRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationSendSmsTokenFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationSendSmsTokenResponse>>() {
        }.getType();
        ResponseMessage<RegistrationSendSmsTokenResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationVerifyMobile() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationVerifyMobileRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationVerifyMobileRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationVerifyMobileFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationVerifyMobileResponse>>() {
        }.getType();
        ResponseMessage<RegistrationVerifyMobileResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationAccountInfo() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationAccountInfoRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationAccountInfoRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationAccountInfoFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationAccountInfoResponse>>() {
        }.getType();
        ResponseMessage<RegistrationAccountInfoResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getComment());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationVerifyAccount() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationVerifyAccountRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationVerifyAccountRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationVerifyAccountFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<VerifyAccountResponse>>() {
        }.getType();
        ResponseMessage<VerifyAccountResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationFetchUserData() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationFetchUserDataRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationFetchUserDataRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationFetchUserDataFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationFetchUserDataResponse>>() {
        }.getType();
        ResponseMessage<RegistrationFetchUserDataResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getFulName());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationConfirmUserData() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationConfirmUserDataRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationConfirmUserDataRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationConfirmUserDataFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationConfirmUserDataResponse>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        Gson gson = builder.create();

        ResponseMessage<RegistrationConfirmUserDataResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getConfirmationDate());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }


    @Test
    public void testRegistrationCredentials() throws Exception {

        Type requestType = new TypeToken<RequestMessage<RegistrationCredentialsRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationCredentialsRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationCredentialsFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationCredentialsResponse>>() {
        }.getType();
        ResponseMessage<RegistrationCredentialsResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<RegistrationEntryRequest> createRegistrationEntryRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationEntryRequest> message = new RequestMessage<RegistrationEntryRequest>();
        message.setRequestHeader(header);
        RegistrationEntryRequest request = new RegistrationEntryRequest();
        request.setRequestUUID("1234");
        request.setCellNumber("09129479928");
        request.setAccountNumber("1823454328");
        request.setBankCode("18");
        request.setNationalCode("0061357710");
        request.setDeviceDTO(new DeviceDTO());
        request.getDeviceDTO().setImei(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationSendSmsTokenRequest> createRegistrationSendSmsTokenRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationSendSmsTokenRequest> message = new RequestMessage<RegistrationSendSmsTokenRequest>();
        message.setRequestHeader(header);
        RegistrationSendSmsTokenRequest request = new RegistrationSendSmsTokenRequest();
        request.setRequestUUID("1234");
        request.setUserIdToken(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationVerifyMobileRequest> createRegistrationVerifyMobileRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationVerifyMobileRequest> message = new RequestMessage<RegistrationVerifyMobileRequest>();
        message.setRequestHeader(header);
        RegistrationVerifyMobileRequest request = new RegistrationVerifyMobileRequest();
        request.setRequestUUID("1234");
        request.setUserIdToken(UUID.randomUUID().toString());
        request.setSmsToken("12345");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationAccountInfoRequest> createRegistrationAccountInfoRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationAccountInfoRequest> message = new RequestMessage<RegistrationAccountInfoRequest>();
        message.setRequestHeader(header);
        RegistrationAccountInfoRequest request = new RegistrationAccountInfoRequest();
        request.setRequestUUID("1234");
        request.setUserIdToken(UUID.randomUUID().toString());
        request.setAccountNumber("1234567890");
        request.setBankCode("18");
        request.setNationalCode("1552195171");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationVerifyAccountRequest> createRegistrationVerifyAccountRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationVerifyAccountRequest> message = new RequestMessage<RegistrationVerifyAccountRequest>();
        message.setRequestHeader(header);
        RegistrationVerifyAccountRequest request = new RegistrationVerifyAccountRequest();
        request.setRequestUUID("1234");
        request.setUserIdToken(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationFetchUserDataRequest> createRegistrationFetchUserDataRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationFetchUserDataRequest> message = new RequestMessage<RegistrationFetchUserDataRequest>();
        message.setRequestHeader(header);
        RegistrationFetchUserDataRequest request = new RegistrationFetchUserDataRequest();
        request.setRequestUUID("1234");
        request.setUserIdToken(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<RegistrationConfirmUserDataRequest> createRegistrationConfirmUserDataRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationConfirmUserDataRequest> message = new RequestMessage<RegistrationConfirmUserDataRequest>();
        message.setRequestHeader(header);
        RegistrationConfirmUserDataRequest request = new RegistrationConfirmUserDataRequest();
        request.setRequestUUID("1234");
        request.setDeviceId(UUID.randomUUID().toString());
        request.setUserIdToken(UUID.randomUUID().toString());
        request.setImei(UUID.randomUUID().toString());
        request.setIp("192.168.1.5");
        request.setIsVerified(true);
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }


    private RequestMessage<RegistrationCredentialsRequest> createRegistrationCredentialsRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationCredentialsRequest> message = new RequestMessage<RegistrationCredentialsRequest>();
        message.setRequestHeader(header);
        RegistrationCredentialsRequest request = new RegistrationCredentialsRequest();
        request.setRequestUUID("1234");
        request.setDeviceId(UUID.randomUUID().toString());
        request.setInstallationToken(UUID.randomUUID().toString());
        request.setMemorableKey("test");
        request.setPassCode("12345");
        request.setUserIdToken(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

}
