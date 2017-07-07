package xyz.homapay.hampay.core.test.flows.misc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BankListRequest;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class BanksTest extends AbstractTestSuite {

    @Test
    public void testBankList() throws Exception {

        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Type requestType = new TypeToken<RequestMessage<BankListRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createBankListRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("BankListFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<BankListResponse>>() {
        }.getType();
        ResponseMessage<BankListResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getBanks());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<BankListRequest> createBankListRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<BankListRequest> message = new RequestMessage<BankListRequest>();
        message.setRequestHeader(header);
        BankListRequest request = new BankListRequest();
        request.setRequestUUID("1234");
        message.setService(request);

        return message;
    }
}
