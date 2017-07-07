package xyz.homapay.hampay.core.test.flows.payment;

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
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentResponse;
import xyz.homapay.hampay.core.common.data.model.*;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class BusinessPaymentTest extends AbstractTestSuite {
    private User user = null;
    private IndividualCustomer customer = null;
    private Account account = null;
    private Transaction trx1 = null;
    private Transaction trx2 = null;
    private Business biz = null;
    private Bank bank = null;

    @Before
    public void init() throws IOException {
        Datastore ds = DbConnection.datastore();
        ds.delete(ds.createQuery(User.class));
        ds.delete(ds.createQuery(IndividualCustomer.class));
        ds.delete(ds.createQuery(Account.class));
        ds.delete(ds.createQuery(Transaction.class));
        ds.delete(ds.createQuery(Business.class));
        ds.delete(ds.createQuery(Bank.class));

        user = new User();
        user.setRegistrationDate(new Date());
        user.setUserId(UUID.randomUUID().toString());
        user.setMobileNo("0099");
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

        bank = new Bank();
        bank.setCode("1019");
        bank.setName("Banke Khun");
        ds.save(bank);

        account = new Account();
        account.setAccountNumber("999999999999");
        account.setCustomer(customer);
        account.setBank(bank);
        ds.save(account);

        customer.getAccounts().add(account);
        customer.setDefaultAccount(account);
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

        Account acc1 = new Account();
        acc1.setAccountNumber("09101010");
        acc1.setCustomer(customer);
        acc1.setBank(bank);
        ds.save(acc1);

        biz = new Business();
        biz.setIdentityCode("007");
        biz.setName("Semsarie Gholi Khan");
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(acc1);
        biz.setAccounts(accountList);
        biz.setDefaultAccount(acc1);
        ds.save(biz);
    }

    @Test
    public void testBusinessPayment() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<BusinessPaymentRequest> requestMessage = createRequest();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<BusinessPaymentRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("BusinessPaymentRequestFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<BusinessPaymentResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<BusinessPaymentResponse>>() {
        }.getType());
        String refCode = response.getService().getRefCode();
        //TODO: below lines are commented because of disability in switch mock
        //assertNotNull(refCode);
        //assertEquals(8, refCode.length());
        //assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<BusinessPaymentRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");

        BusinessPaymentRequest req = new BusinessPaymentRequest();
        req.setBusinessCode("10190");
        req.setAmount(10000L);
        req.setMessage("Boro pul pardakht kon");

        RequestMessage<BusinessPaymentRequest> message = new RequestMessage<BusinessPaymentRequest>();
        message.setRequestHeader(header);
        message.setService(req);

        return message;
    }

}
