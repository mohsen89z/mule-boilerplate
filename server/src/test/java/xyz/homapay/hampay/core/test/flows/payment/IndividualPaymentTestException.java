package xyz.homapay.hampay.core.test.flows.payment;

import com.google.gson.Gson;
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
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentRequest;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentResponse;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.*;
import xyz.homapay.hampay.core.server.service.TransactionService;
import xyz.homapay.hampay.core.server.service.UserService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;
import xyz.homapay.hampay.core.test.TestUtil;

import static junit.framework.Assert.*;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 8/18/15.
 */
public class IndividualPaymentTestException extends AbstractTestSuite {


    private UserService userServiceMock;
    private TransactionService transactionService;

    @Before
    public void init() throws Exception {

        MuleEvent muleEvent = testEvent("");
        userServiceMock = (UserService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("userService");
        transactionService = (TransactionService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("transactionService");

    }

    @Test
    public void testIndividualPaymentUserNotFoundException() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new UserNotFoundException());
        replay(userServiceMock);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();


        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.INVALID_TOKEN_ID);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    private RequestMessage<IndividualPaymentRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");

        IndividualPaymentRequest req = new IndividualPaymentRequest();
        req.setCellNumber("09125252282");
        req.setAmount(10000L);
        req.setMessage("Boro pul pardakht kon. Zud bash");
        req.setRequestUUID("12121212121212");

        RequestMessage<IndividualPaymentRequest> message = new RequestMessage<IndividualPaymentRequest>();
        message.setRequestHeader(header);
        message.setService(req);

        return message;
    }

    @Test
    public void testIndividualPaymentDatabaseException() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new DatabaseException());
        replay(userServiceMock);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();


        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.DATABASE_EXCEPTION);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    @Test
    public void testIndividualPaymentUserNotEligibleToPayException() throws Exception {
        reset(userServiceMock);
        reset(transactionService);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        expect(transactionService.createIndividualTransaction(isA(User.class), isA(IndividualPaymentRequest.class))).andThrow(new UserNotEligibleToPayException());
        replay(userServiceMock);
        replay(transactionService);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);
        verify(transactionService);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.USER_IS_NOT_DELEGATED);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    @Test
    public void testIndividualPaymentDestinationNotEligibleToPayException() throws Exception {
        reset(userServiceMock);
        reset(transactionService);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        expect(transactionService.createIndividualTransaction(isA(User.class), isA(IndividualPaymentRequest.class))).andThrow(new DestinationIsNotEligibleToPayException());
        replay(userServiceMock);
        replay(transactionService);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);
        verify(transactionService);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.DESTINATION_IS_NOT_ACTIVATED);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    @Test
    public void testIndividualPaymentAmountIsNotInRangeException() throws Exception {
        reset(userServiceMock);
        reset(transactionService);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        expect(transactionService.createIndividualTransaction(isA(User.class), isA(IndividualPaymentRequest.class))).andThrow(new PaymentIsNotInRangeException());
        replay(userServiceMock);
        replay(transactionService);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);
        verify(transactionService);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.AMOUNT_IS_NOT_IN_RANGE);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    @Test
    public void testIndividualPaymentRuntimeException() throws Exception {
        reset(userServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andThrow(new RuntimeException());
        replay(userServiceMock);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentSuccess();

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.FAILURE);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

}
