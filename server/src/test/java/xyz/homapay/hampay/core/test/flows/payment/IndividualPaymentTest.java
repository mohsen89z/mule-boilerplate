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
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.service.TransactionService;
import xyz.homapay.hampay.core.server.service.UserService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;
import xyz.homapay.hampay.core.test.TestUtil;

import java.util.Date;

import static junit.framework.Assert.*;
import static org.easymock.EasyMock.*;

/**
 * Created by Ebrahim Pasbani.
 */
public class IndividualPaymentTest extends AbstractTestSuite {

    private UserService userServiceMock;
    private TransactionService transactionServiceMock;

    @Before
    public void init() throws Exception {

        MuleEvent muleEvent = testEvent("");
        userServiceMock = (UserService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("userService");
        transactionServiceMock = (TransactionService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("transactionService");
    }

    @Test
    public void testIndividualPaymentSuccess() throws Exception {
        Transaction transaction = createTransaction();
        reset(userServiceMock);
        reset(transactionServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        expect(transactionServiceMock.createIndividualTransaction(isA(User.class), isA(IndividualPaymentRequest.class))).andReturn(transaction);
        transactionServiceMock.updateTransactionStatusToPending(transaction);
        transactionServiceMock.save(isA(Transaction.class));
        replay(userServiceMock);
        replay(transactionServiceMock);

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
        verify(transactionServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(response.getService().getRefCode(), "HP-12232498323");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    private Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(Transaction.TransactionStatus.INITIATING);
        transaction.setAmount(10000l);
        transaction.setMessage("test");
        transaction.setPersonType(Transaction.PersonType.INDIVIDUAL);
        transaction.setReference("HP-12232498323");
        transaction.setTransactionDate(new Date());
        transaction.setDestinationAccount(new Account());
        transaction.getDestinationAccount().setAccountNumber("55555/22/566966");
        transaction.getDestinationAccount().setBank(new Bank());
        transaction.getDestinationAccount().getBank().setCode("18");
        transaction.getDestinationAccount().getBank().setName("بانک تجارت");
        transaction.setSourceAccount(new Account());
        transaction.getSourceAccount().setAccountNumber("55555/22/566966");
        transaction.getSourceAccount().setBank(new Bank());
        transaction.getSourceAccount().getBank().setCode("18");
        transaction.getSourceAccount().getBank().setName("بانک تجارت");
        return transaction;
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
    public void testIndividualPaymentSwitchFailure() throws Exception {
        Transaction transaction = createTransaction();
        reset(userServiceMock);
        reset(transactionServiceMock);
        expect(userServiceMock.findActivatedUserByUserId("0083519076")).andReturn(TestUtil.createUser1());
        expect(transactionServiceMock.createIndividualTransaction(isA(User.class), isA(IndividualPaymentRequest.class))).andReturn(transaction);
        transactionServiceMock.updateTransactionStatusToPending(transaction);
        transactionServiceMock.save(isA(Transaction.class));
        replay(userServiceMock);
        replay(transactionServiceMock);

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateSuccess(requestMessage.getRequestHeader().getAuthToken());
        mockSwitchPaymentFailure();


        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);
        verify(userServiceMock);
        verify(transactionServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.SWITCH_FAILURE);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

    @Test
    public void testIndividualPaymentAuthenticationFailure() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });
        RequestMessage<IndividualPaymentRequest> requestMessage = createRequest();
        mockIDPAuthenticateFailure(requestMessage.getRequestHeader().getAuthToken());


        Gson gson = new Gson();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<IndividualPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IndividualPaymentRequestFlow", event);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IndividualPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IndividualPaymentResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "12121212121212");
        assertEquals(response.getService().getResultStatus(), ResultStatus.AUTHENTICATION_FAILURE);
        assertNull(response.getService().getRefCode());
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
    }

}
