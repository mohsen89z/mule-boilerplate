package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.request.VerifyAccountRequest;
import xyz.homapay.hampay.common.core.model.request.VerifyTransferMoneyRequest;
import xyz.homapay.hampay.common.core.model.response.VerifyAccountResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.util.UUID;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by sima on 6/28/15.
 */
public class VerifyAccountTest extends AbstractTestSuite {

    @Test
    public void testVerifyAccount() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<VerifyAccountRequest> message = createVerifyAccountRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<VerifyAccountRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("VerifyAccountFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<VerifyAccountResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<VerifyAccountResponse>>() {
        }.getType());
        assertNotNull(response.getService().getResultStatus());
    }

    private RequestMessage<VerifyAccountRequest> createVerifyAccountRequest() {
        RequestMessage<VerifyAccountRequest> requestMessage = new RequestMessage<>();
        VerifyAccountRequest service = new VerifyAccountRequest();
        service.setRequestUUID("123123");
        requestMessage.setService(service);
        requestMessage.setRequestHeader(new RequestHeader());
        requestMessage.getRequestHeader().setAuthToken("022402410321");
        return requestMessage;
    }

    private RequestMessage<VerifyTransferMoneyRequest> createVerifyTransferMoneyRequest() {
        RequestMessage<VerifyTransferMoneyRequest> requestMessage = new RequestMessage<VerifyTransferMoneyRequest>();
        VerifyTransferMoneyRequest service = new VerifyTransferMoneyRequest();
        service.setRequestUUID(UUID.randomUUID().toString());
        RequestHeader header = new RequestHeader();
        header.setAuthToken("9999");
        header.setVersion("1.0-PA");
        requestMessage.setRequestHeader(header);
        requestMessage.setService(service);
        return requestMessage;
    }


    @Test
    public void testTransferMoney() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<VerifyTransferMoneyRequest> message = createTransferMoneyRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<VerifyTransferMoneyRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("VerifyTransferMoneyFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<VerifyAccountResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<VerifyAccountResponse>>() {
        }.getType());
        assertNotNull(response.getService().getResultStatus());
    }

    private RequestMessage<VerifyTransferMoneyRequest> createTransferMoneyRequest() {
        RequestMessage<VerifyTransferMoneyRequest> requestMessage = new RequestMessage<>();
        VerifyTransferMoneyRequest service = new VerifyTransferMoneyRequest();
        service.setRequestUUID("02542021.01");
        requestMessage.setService(service);
        return requestMessage;
    }

}
