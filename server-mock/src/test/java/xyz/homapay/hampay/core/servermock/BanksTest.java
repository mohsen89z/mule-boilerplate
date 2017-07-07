package xyz.homapay.hampay.core.servermock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BankListRequest;
import xyz.homapay.hampay.common.core.model.response.BankListResponse;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class BanksTest extends AbstractTestSuite {

    @Test
    public void testBankList() throws Exception {

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
