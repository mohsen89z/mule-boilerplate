package xyz.homapay.hampay.core.test.flows.tac;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.TACAcceptRequest;
import xyz.homapay.hampay.common.core.model.request.TACRequest;
import xyz.homapay.hampay.common.core.model.response.TACAcceptResponse;
import xyz.homapay.hampay.common.core.model.response.TACResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by sima on 7/2/15.
 */
public class TermsAndConditionsTest extends AbstractTestSuite {

    @Test
    public void testTAC() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<TACRequest> message = createTACRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<TACRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("TermsAndConditionsFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<TACResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<TACResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
    }

    private RequestMessage<TACRequest> createTACRequest() {
        RequestMessage<TACRequest> requestMessage = new RequestMessage<>();
        TACRequest service = new TACRequest();
        service.setRequestUUID("0252424154.231.320");
        requestMessage.setService(service);
        return requestMessage;
    }

    @Test
    public void testTermsAndConditionsAcceptFlow() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<TACAcceptRequest> message = createTACAcceptRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<TACAcceptRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("TermsAndConditionsAcceptFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<TACAcceptResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<TACAcceptResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
    }

    private RequestMessage<TACAcceptRequest> createTACAcceptRequest() {
        RequestMessage<TACAcceptRequest> requestMessage = new RequestMessage<>();
        TACAcceptRequest service = new TACAcceptRequest();
        service.setRequestUUID("025443454540");
        requestMessage.setService(service);
        return requestMessage;
    }
}
