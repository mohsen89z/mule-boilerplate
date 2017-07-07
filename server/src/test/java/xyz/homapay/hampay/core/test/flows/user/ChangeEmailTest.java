package xyz.homapay.hampay.core.test.flows.user;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.config.spring.SpringRegistry;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import org.springframework.context.ApplicationContext;
import xyz.homapay.hampay.common.common.ServiceDefinition;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.ChangeEmailRequest;
import xyz.homapay.hampay.common.core.model.response.ChangeEmailResponse;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.common.exception.UserNotFoundException;
import xyz.homapay.hampay.core.server.service.UserService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;
import xyz.homapay.hampay.core.test.TestUtil;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 10/27/15.
 * sima.ahmadvand@gmail.com
 */
public class ChangeEmailTest extends AbstractTestSuite {
    private UserService userServiceMock;

    @Before
    public void init() throws Exception {
        MuleEvent muleEvent = testEvent("");
        userServiceMock = (UserService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("userService");
    }

    @Test
    public void testChangeEmailSuccess() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        userServiceMock.updateUserEmail(isA(String.class), isA(User.class));
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginSuccess();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    private RequestMessage<ChangeEmailRequest> createChangeEmailRequest() {
        RequestMessage<ChangeEmailRequest> requestMessage = new RequestMessage<>();
        ChangeEmailRequest service = new ChangeEmailRequest();
        service.setEmail("test@info.xyz");
        service.setMemorableWord("test");
        service.setPassCode("test");
        service.setRequestUUID("503f3sd5435434f");
        requestMessage.setService(service);
        RequestHeader header = new RequestHeader();
        header.setAuthToken("39486759345786ehrtgkjtrh8674987");
        header.setVersion("1");
        requestMessage.setRequestHeader(header);
        return requestMessage;
    }

    @Test
    public void testChangeEmailAuthFailure() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateFailure(message.getRequestHeader().getAuthToken());
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.AUTHENTICATION_FAILURE);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailInvalidPassCode() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginFailure();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.INVALID_PASSCODE);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailUserNotFound() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new UserNotFoundException());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginFailure();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.INVALID_TOKEN_ID);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailRuntimeException1() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new RuntimeException());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginFailure();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.FAILURE);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailDatabaseException1() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new DatabaseException());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginFailure();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.DATABASE_EXCEPTION);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailDatabaseException2() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        userServiceMock.updateUserEmail(isA(String.class), isA(User.class));
        expectLastCall().andThrow(new DatabaseException());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginSuccess();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.DATABASE_EXCEPTION);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailInvalidFormatException() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        userServiceMock.updateUserEmail(isA(String.class), isA(User.class));
        expectLastCall().andThrow(new InvalidFormatException("Email format is invalid", "test@info.xyz", String.class));
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginSuccess();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.INVALID_EMAIL);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }

    @Test
    public void testChangeEmailRuntimeException2() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        userServiceMock.updateUserEmail(isA(String.class), isA(User.class));
        expectLastCall().andThrow(new RuntimeException());
        replay(userServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<ChangeEmailRequest> message = createChangeEmailRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<ChangeEmailRequest>>() {
        }.getType());
        mockIDPAuthenticateSuccess(message.getRequestHeader().getAuthToken());
        mockIDPLoginSuccess();
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ChangeEmailFlow", event);
        verify(userServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ChangeEmailResponse> response = gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ChangeEmailResponse>>() {
        }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.FAILURE);
        assertEquals(response.getService().getRequestUUID(), "503f3sd5435434f");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.CHANGE_EMAIL);
    }
}
