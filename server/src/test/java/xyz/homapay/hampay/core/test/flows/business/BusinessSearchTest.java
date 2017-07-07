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
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessSearchRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by sima on 6/25/15.
 */
public class BusinessSearchTest extends AbstractTestSuite {

    private Business biz1 = null;
    private Business biz2 = null;

    @Before
    public void init() throws IOException {

//        Datastore ds = DbConnection.datastore();
//        ds.delete(ds.createQuery(Business.class));
//
//        biz1 = new Business();
//        biz1.setCode("007");
//        ds.save(biz1);
//
//        biz2 = new Business();
//        biz2.setCode("309");
//        ds.save(biz2);
    }

    @Test
    public void testBusinessSearchFlow() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<BusinessSearchRequest> message = createRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<BusinessSearchRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("BusinessSearchFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<BusinessListResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<BusinessListResponse>>() {
        }.getType());
        List<BusinessDTO> body = response.getService().getBusinesses();

        assertNotNull(body);
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
    }

    private RequestMessage<BusinessSearchRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");

        BusinessSearchRequest service = new BusinessSearchRequest();
        service.setPageNumber(0);
        service.setPageSize(10);
        service.setTerm("MaHaK");
        RequestMessage<BusinessSearchRequest> message = new RequestMessage<BusinessSearchRequest>();
        message.setRequestHeader(header);
        message.setService(service);
        return message;
    }
}
