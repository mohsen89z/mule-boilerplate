package xyz.homapay.hampay.core.test.flows.security;

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
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.RegistrationFetchUserDataRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationFetchUserDataResponse;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ebrahim Pasbani.
 */
public class RegistrationFetchUserDataTest extends AbstractTestSuite {
    private String userIdToken;
    private Bank bank;
    private IndividualCustomer customer;
    private Account account;
    private User user;

    @Before
    public void init() throws IOException {
        Datastore ds = DbConnection.datastore();
        ds.delete(ds.find(User.class));
        ds.delete(ds.find(Account.class));
        ds.delete(ds.find(IndividualCustomer.class));
        ds.delete(ds.find(Bank.class));

        userIdToken = "6767866678687";
        bank = new Bank();
        bank.setCode("1010");
        bank.setName("Banke Shoma");
        ds.save(bank);

        account = new Account();
        account.setAccountNumber("8787");
        account.setBank(bank);
        ds.save(account);

        customer = new IndividualCustomer();
        customer.setPhoneNumber("091009109");
        customer.setDefaultAccount(account);
        customer.getAccounts().add(account);
        customer.setFullEnglishName("Mirza Naghi");
        customer.setIdentityCode("0981010101");
        ds.save(customer);

        user = new User();
        user.setCustomer(customer);
        user.setMobileNo(customer.getPhoneNumber());
        user.setUserIdToken(userIdToken);
        ds.save(user);
    }

    @Test
    public void testRegistrationFetchUserData() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<RegistrationFetchUserDataRequest> requestMessage = createRequest();
        String jsonRequest = gson.toJson(requestMessage, new TypeToken<RequestMessage<RegistrationFetchUserDataRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonRequest);
        MuleEvent result = runFlow("RegistrationFetchUserDataFlow", event);

        ResponseMessage<RegistrationFetchUserDataResponse> responseMessage = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<RegistrationFetchUserDataResponse>>() {
        }.getType());

        assertEquals(ResultStatus.REGISTRATION_INVALID_STEP, responseMessage.getService().getResultStatus());
    }

    private RequestMessage<RegistrationFetchUserDataRequest> createRequest() {
        RequestMessage<RegistrationFetchUserDataRequest> message = new RequestMessage<RegistrationFetchUserDataRequest>();

        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("9984737");
        message.setRequestHeader(header);

        RegistrationFetchUserDataRequest request = new RegistrationFetchUserDataRequest();
        request.setUserIdToken(userIdToken);
        request.setRequestUUID(UUID.randomUUID().toString());
        message.setService(request);

        return message;

    }
}
