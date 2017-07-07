package xyz.homapay.hampay.core.test.flows.transaction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.request.TransactionListRequest;
import xyz.homapay.hampay.common.core.model.response.TransactionListResponse;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class TransactionListTest extends AbstractTestSuite {
    private User user = null;
    private IndividualCustomer customer = null;
    private Account account = null;
    private Transaction trx1 = null;
    private Transaction trx2 = null;

    @Before
    public void init() throws IOException {
        Datastore ds = DbConnection.datastore();
        ds.delete(ds.createQuery(User.class));
        ds.delete(ds.createQuery(IndividualCustomer.class));
        ds.delete(ds.createQuery(Account.class));
        ds.delete(ds.createQuery(Transaction.class));

        user = new User();
        user.setRegistrationDate(new Date());
        user.setUserId(UUID.randomUUID().toString());
        Object userId = ds.save(user).getId();

        customer = new IndividualCustomer();
        customer.setName("Mr Gholi");
        customer.setPhoneNumber("0098999119");
        customer.getUsers().add(user);
        Object customerId = ds.save(customer).getId();

        user = ds.find(User.class).field("id").equal(userId).get();
        customer = ds.find(IndividualCustomer.class).field("id").equal(customerId).get();
        user.setCustomer(customer);
        ds.save(user);

        account = new Account();
        account.setAccountNumber("999999999999");
        account.setCustomer(customer);
        ds.save(account);

        customer.getAccounts().add(account);
        ds.save(customer);


        trx1 = new Transaction();
        trx1.setAmount(1000000L);
        trx1.setMessage("Hey there");
        trx1.setReference(UUID.randomUUID().toString());
        trx1.setTransactionDate(null);
        trx1.setPersonType(Transaction.PersonType.INDIVIDUAL);
        trx1.setSourceAccount(account);
        trx1.setTransactionStatus(Transaction.TransactionStatus.SUCCESS);
        ds.save(trx1);

        trx2 = new Transaction();
        trx2.setAmount(898900L);
        trx2.setMessage("Luli");
        trx2.setReference(UUID.randomUUID().toString());
        trx2.setTransactionDate(null);
        trx2.setPersonType(Transaction.PersonType.BUSINESS);
        trx2.setSourceAccount(null);
        trx2.setTransactionStatus(Transaction.TransactionStatus.SUCCESS);
        ds.save(trx2);
    }

    @Test
    public void testTrxListByUserId() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<TransactionListRequest> message = createRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<TransactionListRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("TransactionListByUserIdFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<TransactionListResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<TransactionListResponse>>() {
        }.getType());
        List<xyz.homapay.hampay.common.core.model.response.dto.TransactionDTO> body = response.getService().getTransactions();

        assertNotNull(body);
        assertEquals(1, body.size());
        assertEquals(trx1.getAmount(), body.get(0).getAmount());
    }

    private RequestMessage<TransactionListRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");


        TransactionListRequest req = new TransactionListRequest();
        req.setUserId(user.getUserId());
        req.setPageNumber(0);
        req.setPageSize(10);

        RequestMessage<TransactionListRequest> message = new RequestMessage<TransactionListRequest>();
        message.setRequestHeader(header);
        message.setService(req);

        return message;
    }
}
