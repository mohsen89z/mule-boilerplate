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
import xyz.homapay.hampay.common.core.model.request.ChangePassCodeRequest;
import xyz.homapay.hampay.common.core.model.response.ChangePassCodeResponse;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithmsImpl;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ebrahim Pasbani.
 */
public class ChangePassCodeTest extends AbstractTestSuite {
    private String authToken = null;
    private String currPasscode = null;
    private String newPasscode = null;
    private String memorableCode = null;
    private String deviceId = null;
    private String installationToken = null;
    private String username = null;
    private String currentPassword = null;

    @Before
    public void init() {
        authToken = "100101010";
        currPasscode = "12345";
        newPasscode = "09898";
        memorableCode = "Hey you";
        deviceId = "6475634563748";
        installationToken = "989898989";
        username = "093246572";
        currentPassword = new SecurityAlgorithmsImpl().generatePassword(memorableCode, currPasscode, deviceId, installationToken);
    }

    @Test
    public void testChangePassCode() throws Exception {

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
        RequestMessage<ChangePassCodeRequest> requestMessage = createRequest();
        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<ChangePassCodeRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonRequest);

        event.setFlowVariable("currentUser.deviceId", deviceId);
        event.setFlowVariable("currentUser.installationToken", installationToken);
        event.setFlowVariable("currentUser.username", username);

        MuleEvent result = runFlow("ChangePasscodeFlow", event);

        ResponseMessage<ChangePassCodeResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangePassCodeResponse>>() {
        }.getType());

        assertEquals(ResultStatus.SUCCESS, responseMessage.getService().getResultStatus());
    }

    @Test
    public void testChangePassCodeWithWrongCurrPassCode() throws Exception {

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
                    muleMessage.setProperty("userpassword", "wrong", PropertyScope.INBOUND);
                }

                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<ChangePassCodeRequest> requestMessage = createRequest();
        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<ChangePassCodeRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonRequest);

        event.setFlowVariable("currentUser.deviceId", deviceId);
        event.setFlowVariable("currentUser.installationToken", installationToken);
        event.setFlowVariable("currentUser.username", username);

        MuleEvent result = runFlow("ChangePasscodeFlow", event);

        ResponseMessage<ChangePassCodeResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangePassCodeResponse>>() {
        }.getType());

        assertEquals(ResultStatus.FAILURE, responseMessage.getService().getResultStatus());
    }

    private RequestMessage<ChangePassCodeRequest> createRequest() {
        RequestMessage<ChangePassCodeRequest> message = new RequestMessage<ChangePassCodeRequest>();
        RequestHeader header = new RequestHeader();
        header.setAuthToken(authToken);
        header.setVersion("1.0-PA");

        ChangePassCodeRequest request = new ChangePassCodeRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setCurrentPassCode(currPasscode);
        request.setMemorableCode(memorableCode);
        request.setNewPassCode(newPasscode);

        message.setRequestHeader(header);
        message.setService(request);
        return message;
    }
}
