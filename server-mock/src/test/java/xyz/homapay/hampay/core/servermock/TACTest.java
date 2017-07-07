package xyz.homapay.hampay.core.servermock;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.TACAcceptRequest;
import xyz.homapay.hampay.common.core.model.request.TACRequest;
import xyz.homapay.hampay.common.core.model.response.TACAcceptResponse;
import xyz.homapay.hampay.common.core.model.response.TACResponse;

import java.lang.reflect.Type;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Siavash Mahmoudpour
 */
public class TACTest extends AbstractTestSuite {

    @Test
    public void testTAC() throws Exception {

        Type requestType = new TypeToken<RequestMessage<TACRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createTACRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("TACFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<TACResponse>>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        Gson gson = builder.create();

        ResponseMessage<TACResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
        assertTrue(response.getService().getTac() != null || response.getService().getUserProfile() != null);
    }

    @Test
    public void testTACAccept() throws Exception {

        Type requestType = new TypeToken<RequestMessage<TACAcceptRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createTACAcceptRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("TACAcceptFlow", event);
        assertNotNull(result.getMessage().getPayload());

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        Type responseType = new TypeToken<ResponseMessage<TACAcceptResponse>>() {
        }.getType();
        ResponseMessage<TACAcceptResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getUserProfile());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<TACRequest> createTACRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<TACRequest> message = new RequestMessage<TACRequest>();
        message.setRequestHeader(header);
        TACRequest request = new TACRequest();
        request.setRequestUUID("1234");

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<TACAcceptRequest> createTACAcceptRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<TACAcceptRequest> message = new RequestMessage<TACAcceptRequest>();
        message.setRequestHeader(header);
        TACAcceptRequest request = new TACAcceptRequest();
        request.setRequestUUID("1234");

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }
}
