package xyz.homapay.hampay.core.test.flows.business;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentConfirmRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessPaymentConfirmResponse;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.UUID;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class BusinessPaymentConfirmTest extends AbstractTestSuite {

    private Business biz = null;
    private Account account = null;
    private Bank bank = null;

    @Before
    public void init() throws IOException {
        DbConnection.datastore().delete(DbConnection.datastore().find(Business.class));
        DbConnection.datastore().delete(DbConnection.datastore().find(Account.class));

        bank = new Bank();
        bank.setName("Banke TM");
        bank.setCode("0009");
        DbConnection.datastore().save(bank);

        account = new Account();
        account.setBank(bank);
        account.setAccountNumber("7676878");
        DbConnection.datastore().save(account);

        biz = new Business();
        biz.setName("Semsarie Ghule Cheraghe Jadou");
        biz.setIdentityCode("10190");
        biz.setDefaultAccount(account);
        biz.getAccounts().add(account);
        DbConnection.datastore().save(biz);
    }

    @Test
    public void testBusinessPaymentConfirm() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<BusinessPaymentConfirmRequest> requestMessage = createRequest();
        String jsonMessage = gson.toJson(requestMessage, new TypeToken<RequestMessage<BusinessPaymentConfirmRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("GetBusinessInfoFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<BusinessPaymentConfirmResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<BusinessPaymentConfirmResponse>>() {
        }.getType());
        //TODO: Below lines are commented because of disability in switch mock
        /*assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
        assertNotNull(response.getService().getBusinessCode());
        assertNotNull(response.getService().getFullName());*/
    }

    private RequestMessage<BusinessPaymentConfirmRequest> createRequest() {
        RequestMessage<BusinessPaymentConfirmRequest> message = new RequestMessage<BusinessPaymentConfirmRequest>();

        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");
        message.setRequestHeader(header);

        BusinessPaymentConfirmRequest request = new BusinessPaymentConfirmRequest();
        request.setRequestUUID(UUID.randomUUID().toString());
        request.setBusinessCode(biz.getIdentityCode());
        message.setService(request);

        return message;
    }
}
