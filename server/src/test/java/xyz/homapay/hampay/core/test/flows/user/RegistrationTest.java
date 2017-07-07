package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.config.spring.SpringRegistry;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import org.springframework.context.ApplicationContext;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.DeviceDTO;
import xyz.homapay.hampay.common.core.model.request.RegistrationEntryRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationEntryResponse;
import xyz.homapay.hampay.core.server.service.RegistrationService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class RegistrationTest extends AbstractTestSuite {

    private RegistrationService registrationServiceMock;

    @Before
    public void init() throws Exception {

        MuleEvent muleEvent = testEvent("");
        registrationServiceMock = (RegistrationService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("registrationService");
    }

    @Test
    public void testRegistrationEntry() throws Exception {
        reset(registrationServiceMock);
//        expect()
        replay(registrationServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Type requestType = new TypeToken<RequestMessage<RegistrationEntryRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createRegistrationEntryRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("RegistrationEntryFlow", event);
        verify(registrationServiceMock);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<RegistrationEntryResponse>>() {
        }.getType();
        ResponseMessage<RegistrationEntryResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getUserIdToken());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
        System.out.println("User id token : " + response.getService().getUserIdToken());
    }

    //    @Test
//    public void testRegistrationSendSmsToken() throws Exception {
//
//        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
//            public MuleMessage transform(MuleMessage muleMessage) {
//                return muleMessage;
//            }
//        });
//
//        Type requestType = new TypeToken<RequestMessage<RegistrationSendSmsTokenRequest>>() {}.getType();
//        String jsonString = new Gson().toJson(createRegistrationSendSmsTokenRequest(), requestType);
//
//        MuleEvent event = testEvent(jsonString);
//        MuleEvent result = runFlow("RegistrationSendSmsTokenFlow", event);
//        assertNotNull(result.getMessage().getPayload());
//
//        Type responseType = new TypeToken<ResponseMessage<RegistrationSendSmsTokenResponse>>() {}.getType();
//        ResponseMessage<RegistrationSendSmsTokenResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);
//
//        assertNotNull(response.getService());
//        assertNotNull(response.getService().getRequestUUID());
//        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
//    }
//
//    @Test
//    public void testRegistrationVerifyMobile() throws Exception {
//
//        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
//            public MuleMessage transform(MuleMessage muleMessage) {
//                return muleMessage;
//            }
//        });
//
//        Type requestType = new TypeToken<RequestMessage<RegistrationVerifyMobileRequest>>() {}.getType();
//        String jsonString = new Gson().toJson(createRegistrationVerifyMobileRequest(), requestType);
//
//        MuleEvent event = testEvent(jsonString);
//        MuleEvent result = runFlow("RegistrationVerifyMobileFlow", event);
//        assertNotNull(result.getMessage().getPayload());
//
//        Type responseType = new TypeToken<ResponseMessage<RegistrationVerifyMobileResponse>>() {}.getType();
//        ResponseMessage<RegistrationVerifyMobileResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);
//
//        assertNotNull(response.getService());
//        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
//        assertTrue(response.getService().getIsVerified());
//    }
//
//
    private RequestMessage<RegistrationEntryRequest> createRegistrationEntryRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<RegistrationEntryRequest> message = new RequestMessage<RegistrationEntryRequest>();
        message.setRequestHeader(header);
        RegistrationEntryRequest request = new RegistrationEntryRequest();
        request.setRequestUUID("1234");
//        request.setCellNumber("09129479928");
        request.setCellNumber("09124267712");
//        request.setAccountNumber("1823454328");
        request.setAccountNumber("8787");
//        request.setBankCode("18");
        request.setBankCode("1010");
        request.setNationalCode("0061357710");
        request.setDeviceDTO(new DeviceDTO());
        request.getDeviceDTO().setImei(UUID.randomUUID().toString());
        message.setService(request);
        message.getService().getRequestUUID();
        return message;
    }

    private byte[] zipRequest(String jsonMessage) throws IOException {
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(jsonMessage.getBytes("UTF-8"));
        gzip.close();
        return obj.toByteArray();
    }

//    private RequestMessage<RegistrationSendSmsTokenRequest> createRegistrationSendSmsTokenRequest() {
//        RequestHeader header = new RequestHeader();
//        header.setAuthToken("008ewe");
//        header.setVersion("1.0-PA");
//
//        RequestMessage<RegistrationSendSmsTokenRequest> message = new RequestMessage<RegistrationSendSmsTokenRequest>();
//        message.setRequestHeader(header);
//        RegistrationSendSmsTokenRequest request = new RegistrationSendSmsTokenRequest();
//        request.setRequestUUID("12345");
//        request.setUserIdToken("6767866678687");
//        message.setService(request);
//        message.getService().getRequestUUID();
//
//        return message;
//    }
//
//    private RequestMessage<RegistrationVerifyMobileRequest> createRegistrationVerifyMobileRequest() {
//        RequestHeader header = new RequestHeader();
//        header.setAuthToken("008ewe");
//        header.setVersion("1.0-PA");
//
//        RequestMessage<RegistrationVerifyMobileRequest> message = new RequestMessage<RegistrationVerifyMobileRequest>();
//        message.setRequestHeader(header);
//        RegistrationVerifyMobileRequest request = new RegistrationVerifyMobileRequest();
//        request.setRequestUUID("1234");
//        request.setUserIdToken("3f3d0bcc-c86d-448c-8425-c8149ac73e72");
//        request.setSmsToken("49527");
//        message.setService(request);
//        message.getService().getRequestUUID();
//
//        return message;
//    }
//
//
//
//    @Test
//    public void testRegistrationSendSmsTokenException() throws Exception {
//
//        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
//            public MuleMessage transform(MuleMessage muleMessage) {
//                return muleMessage;
//            }
//        });
//
//        Type requestType = new TypeToken<RequestMessage<RegistrationSendSmsTokenRequest>>() {}.getType();
//        String jsonString = new Gson().toJson(createRegistrationSendSmsTokenRequest(), requestType);
//
//        MuleEvent event = testEvent(jsonString);
//        MuleEvent result = runFlow("RegistrationSendSmsTokenFlow", event);
//        assertNotNull(result.getMessage().getPayload());
//
//        Type responseType = new TypeToken<ResponseMessage<RegistrationSendSmsTokenResponse>>() {}.getType();
//        ResponseMessage<RegistrationSendSmsTokenResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);
//
//        assertNotNull(response.getService());
//        assertNotNull(response.getService().getRequestUUID());
//        assertEquals(ResultStatus.INVALID_TOKEN_ID, response.getService().getResultStatus());
//    }

}
