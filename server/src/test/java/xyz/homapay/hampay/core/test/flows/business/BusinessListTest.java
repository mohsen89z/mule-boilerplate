package xyz.homapay.hampay.core.test.flows.business;

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
import xyz.homapay.hampay.common.core.model.request.BusinessListRequest;
import xyz.homapay.hampay.common.core.model.response.BusinessListResponse;
import xyz.homapay.hampay.common.core.model.response.dto.BusinessDTO;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class BusinessListTest extends AbstractTestSuite {

    private Business biz1 = null;
    private Business biz2 = null;

    @Before
    public void init() throws IOException {

        Datastore ds = DbConnection.datastore();
        ds.delete(ds.createQuery(Business.class));

        biz1 = new Business();
        biz1.setIdentityCode("007");
        ds.save(biz1);

        biz2 = new Business();
        biz2.setIdentityCode("309");
        ds.save(biz2);
    }

    @Test
    public void testAllBusinessListFlow() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<BusinessListRequest> message = createRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<BusinessListRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("BusinessListAllFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<BusinessListResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<BusinessListResponse>>() {
        }.getType());
        List<BusinessDTO> body = response.getService().getBusinesses();

        assertNotNull(body);
        assertEquals(2, body.size());
    }

    private RequestMessage<BusinessListRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");

        BusinessListRequest req = new BusinessListRequest();
        req.setPageNumber(0);
        req.setPageSize(10);

        RequestMessage<BusinessListRequest> message = new RequestMessage<BusinessListRequest>();
        message.setRequestHeader(header);
        message.setService(req);

        return message;
    }
}
