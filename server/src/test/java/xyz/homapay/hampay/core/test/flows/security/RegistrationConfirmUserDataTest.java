package xyz.homapay.hampay.core.test.flows.security;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.RegistrationConfirmUserDataRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationConfirmUserDataResponse;
import xyz.homapay.hampay.core.common.data.model.IdentityAcknowledgment;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class RegistrationConfirmUserDataTest extends AbstractTestSuite {
    private User user;

    @Before
    public void init() throws IOException {
        Datastore ds = DbConnection.datastore();
        ds.delete(ds.find(User.class));

        user = new User();
        user.setUserIdToken("943782374");
        ds.save(user);
    }

    @Test
    public void testRegistrationConfirmUserData() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = gson();
        RequestMessage<RegistrationConfirmUserDataRequest> requestMessage = createRequest();
        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<RegistrationConfirmUserDataRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonRequest);
        MuleEvent result = runFlow("RegistrationConfirmUserDataFlow", event);


        ResponseMessage<RegistrationConfirmUserDataResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<RegistrationConfirmUserDataResponse>>() {
        }.getType());

        assertEquals(ResultStatus.REGISTRATION_INVALID_STEP, responseMessage.getService().getResultStatus());
        assertNotNull(responseMessage.getService().getConfirmationDate());

        IdentityAcknowledgment ack = DbConnection.datastore().find(IdentityAcknowledgment.class).field("userIdToken").equal(user.getUserIdToken()).get();
        assertNotNull(ack);
    }

    private RequestMessage<RegistrationConfirmUserDataRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("889888");
        header.setVersion("1.0-PA");

        RegistrationConfirmUserDataRequest request = new RegistrationConfirmUserDataRequest();
        request.setUserIdToken(user.getUserIdToken());
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setImei("8sd987f8sd7f87sd8f7sdf");
        request.setIp("1.1.1.1");
        request.setDeviceId("89384982349");
        request.setIsVerified(true);

        RequestMessage<RegistrationConfirmUserDataRequest> message = new RequestMessage<RegistrationConfirmUserDataRequest>();
        message.setRequestHeader(header);
        message.setService(request);
        return message;
    }

}
