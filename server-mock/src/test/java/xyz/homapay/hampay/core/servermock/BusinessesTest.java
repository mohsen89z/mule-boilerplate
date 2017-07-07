package xyz.homapay.hampay.core.servermock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessListRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class BusinessesTest extends AbstractTestSuite {

    @Test
    public void testBusinessList() throws Exception {

        Type requestType = new TypeToken<RequestMessage<BusinessListRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createBusinessListRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("BusinessListFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<BusinessListResponse>>() {
        }.getType();
        ResponseMessage<BusinessListResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getBusinesses());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<BusinessListRequest> createBusinessListRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<BusinessListRequest> message = new RequestMessage<BusinessListRequest>();
        message.setRequestHeader(header);
        BusinessListRequest request = new BusinessListRequest();
        request.setRequestUUID("1234");
        request.setPageNumber(0);
        request.setPageSize(10);
        message.setService(request);

        return message;
    }

}
