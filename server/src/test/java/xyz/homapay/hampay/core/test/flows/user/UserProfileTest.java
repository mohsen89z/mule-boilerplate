package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.UserProfileRequest;
import xyz.homapay.hampay.common.core.model.response.UserProfileResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by sima on 7/5/15.
 */
public class UserProfileTest extends AbstractTestSuite {

    @Test
    public void testUserProfile() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<UserProfileRequest> message = createUserProfileRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<UserProfileRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("UserProfileFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<UserProfileResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<UserProfileResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(response.getService().getRequestUUID(), "7345378459837459837");
    }

    private RequestMessage<UserProfileRequest> createUserProfileRequest() {
        RequestMessage<UserProfileRequest> requestMessage = new RequestMessage<>();
        UserProfileRequest service = new UserProfileRequest();
        service.setRequestUUID("7345378459837459837");
        requestMessage.setService(service);
        return requestMessage;
    }
}
