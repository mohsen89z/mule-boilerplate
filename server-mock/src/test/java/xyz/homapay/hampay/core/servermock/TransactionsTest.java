package xyz.homapay.hampay.core.servermock;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.TransactionListRequest;
import xyz.homapay.hampay.common.core.model.response.TransactionListResponse;

import java.lang.reflect.Type;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class TransactionsTest extends AbstractTestSuite {

    @Test
    public void testTransactionList() throws Exception {

        Type requestType = new TypeToken<RequestMessage<TransactionListRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createTransactionListRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("TransactionListFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<TransactionListResponse>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        Gson gson = builder.create();
        ResponseMessage<TransactionListResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getTransactions());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<TransactionListRequest> createTransactionListRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<TransactionListRequest> message = new RequestMessage<TransactionListRequest>();
        message.setRequestHeader(header);
        TransactionListRequest request = new TransactionListRequest();
        request.setRequestUUID("1234");
        request.setPageNumber(0);
        request.setPageSize(10);
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }
}
