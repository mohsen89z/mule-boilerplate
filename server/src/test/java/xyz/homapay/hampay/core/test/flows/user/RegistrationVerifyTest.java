package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.request.RegistrationVerifyAccountRequest;
import xyz.homapay.hampay.common.core.model.request.RegistrationVerifyTransferMoneyRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationVerifyAccountResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by sima on 6/30/15.
 */
public class RegistrationVerifyTest extends AbstractTestSuite {

    @Test
    public void testRegistrationVerifyAccount() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<RegistrationVerifyAccountRequest> message = createRegistrationVerifyAccountRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<RegistrationVerifyAccountRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("RegistrationVerifyAccountFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<RegistrationVerifyAccountResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<RegistrationVerifyAccountResponse>>() {
        }.getType());
        assertNotNull(response.getService().getResultStatus());
    }

    @Test
    public void testRegistrationTransferMoney() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<RegistrationVerifyTransferMoneyRequest> message = createRegistrationTransferMoneyRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<RegistrationVerifyTransferMoneyRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("RegistrationVerifyTransferMoneyFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<RegistrationVerifyAccountResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<RegistrationVerifyAccountResponse>>() {
        }.getType());
        assertNotNull(response.getService().getResultStatus());
    }

    private RequestMessage<RegistrationVerifyTransferMoneyRequest> createRegistrationTransferMoneyRequest() {
        RequestMessage<RegistrationVerifyTransferMoneyRequest> requestMessage = new RequestMessage<>();
        RegistrationVerifyTransferMoneyRequest service = new RegistrationVerifyTransferMoneyRequest();
        service.setUserIdToken("6767866678687");
        service.setRequestUUID("02542021.01");
        requestMessage.setService(service);
        return requestMessage;
    }

    private RequestMessage<RegistrationVerifyAccountRequest> createRegistrationVerifyAccountRequest() {
        RequestMessage<RegistrationVerifyAccountRequest> requestMessage = new RequestMessage<>();
        RegistrationVerifyAccountRequest service = new RegistrationVerifyAccountRequest();
        service.setRequestUUID("123123");
        service.setUserIdToken("6767866678687");
        requestMessage.setService(service);
        return requestMessage;
    }
}
