package xyz.homapay.hampay.core.test.flows.security;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.ChangeMemorableWordRequest;
import xyz.homapay.hampay.common.core.model.response.ChangeMemorableWordResponse;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithmsImpl;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ebrahim Pasbani.
 */
public class ChangeMemorableWordTest extends AbstractTestSuite {
    private String authToken = null;
    private String passCode = null;
    private String currMemorableCode = null;
    private String newMemorableCode = null;
    private String deviceId = null;
    private String installationToken = null;
    private String username = null;
    private String currentPassword = null;

    @Before
    public void init() {
        authToken = "100101010";
        deviceId = "6475634563748";
        installationToken = "989898989";
        username = "093246572";
        currMemorableCode = "Hey you";
        newMemorableCode = "Hi you. Come here";
        passCode = "01910";
        currentPassword = new SecurityAlgorithmsImpl().generatePassword(currMemorableCode, passCode, deviceId, installationToken);
    }

    @Test
    public void testChangeMemorableWord() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
//
//        whenMessageProcessor("outbound-endpoint").ofNamespace("http").thenApply(new MuleMessageTransformer() {
//            public MuleMessage transform(MuleMessage muleMessage) {
//
//                //flow : ChangePasswordIdentityProvider
//                if(muleMessage.getOutboundPropertyNames().contains("data"))
//                {
//                    muleMessage.setProperty("http.status", 201, PropertyScope.INBOUND);
//                }
//                else
//                {
//                    //flow : GetUserPasswordByTokenIdentityProvider
//                    muleMessage.setProperty("http.status", 200, PropertyScope.INBOUND);
//                    muleMessage.setProperty("username", username, PropertyScope.INBOUND);
//                    muleMessage.setProperty("userpassword", currentPassword, PropertyScope.INBOUND);
//                }
//
//                return muleMessage;
//            }
//        });
//
        Gson gson = new Gson();
//        RequestMessage<ChangeMemorableWordRequest> requestMessage = createRequest();
//        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<ChangeMemorableWordRequest>>() {
//        }.getType());
        MuleEvent event = testEvent("{\"requestHeader\":{\"authToken\":\"AQIC5wM2LY4SfcwDLpSjyYdQs_Y0vP8DslpJnwO5RNxXFzY.*AAJTSQACMDEAAlNLABM1Nzk5MTM1NjM3NDYyMjk4NjM3*\",\"version\":\"1.0-PA\"},\"service\":{\"currentMemorableWord\":\"test\",\"newMemorableWord\":\"ttt\",\"passCode\":\"12345\",\"requestUUID\":\"1234\"}}");

//        event.setFlowVariable("currentUser.deviceId", deviceId);
//        event.setFlowVariable("currentUser.installationToken", installationToken);
//        event.setFlowVariable("currentUser.username", username);

        MuleEvent result = runFlow("ChangeMemorableWordFlow", event);

        ResponseMessage<ChangeMemorableWordResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeMemorableWordResponse>>() {
        }.getType());

        assertEquals(ResultStatus.SUCCESS, responseMessage.getService().getResultStatus());
    }

    @Test
    public void testChangeMemorableWordWithWrongMemorableWord() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        whenMessageProcessor("outbound-endpoint").ofNamespace("http").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {

                //flow : ChangePasswordIdentityProvider
                if (muleMessage.getOutboundPropertyNames().contains("data")) {
                    muleMessage.setProperty("http.status", 201, PropertyScope.INBOUND);
                } else {
                    //flow : GetUserPasswordByTokenIdentityProvider
                    muleMessage.setProperty("http.status", 200, PropertyScope.INBOUND);
                    muleMessage.setProperty("username", username, PropertyScope.INBOUND);
                    muleMessage.setProperty("userpassword", currentPassword, PropertyScope.INBOUND);
                }

                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<ChangeMemorableWordRequest> requestMessage = createWrongRequest();
        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<ChangeMemorableWordRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonRequest);

        event.setFlowVariable("currentUser.deviceId", deviceId);
        event.setFlowVariable("currentUser.installationToken", installationToken);
        event.setFlowVariable("currentUser.username", username);

        MuleEvent result = runFlow("ChangeMemorableWordFlow", event);

        ResponseMessage<ChangeMemorableWordResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeMemorableWordResponse>>() {
        }.getType());

        assertEquals(ResultStatus.FAILURE, responseMessage.getService().getResultStatus());
    }

    private RequestMessage<ChangeMemorableWordRequest> createRequest() {
        RequestMessage<ChangeMemorableWordRequest> message = new RequestMessage<ChangeMemorableWordRequest>();
        RequestHeader header = new RequestHeader();
        header.setAuthToken(authToken);
        header.setVersion("1.0-PA");

        ChangeMemorableWordRequest request = new ChangeMemorableWordRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setCurrentMemorableWord(currMemorableCode);
        request.setNewMemorableWord(newMemorableCode);
        request.setPassCode(passCode);

        message.setRequestHeader(header);
        message.setService(request);
        return message;
    }

    private RequestMessage<ChangeMemorableWordRequest> createWrongRequest() {
        RequestMessage<ChangeMemorableWordRequest> message = new RequestMessage<ChangeMemorableWordRequest>();
        RequestHeader header = new RequestHeader();
        header.setAuthToken(authToken);
        header.setVersion("1.0-PA");

        ChangeMemorableWordRequest request = new ChangeMemorableWordRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setCurrentMemorableWord(currMemorableCode);
        request.setNewMemorableWord(newMemorableCode + "!");
        request.setPassCode(passCode);

        message.setRequestHeader(header);
        message.setService(request);
        return message;
    }
}
