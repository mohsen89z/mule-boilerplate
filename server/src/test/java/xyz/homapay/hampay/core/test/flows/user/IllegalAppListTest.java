package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.config.spring.SpringRegistry;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import org.springframework.context.ApplicationContext;
import xyz.homapay.hampay.common.common.ServiceDefinition;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.IllegalAppListRequest;
import xyz.homapay.hampay.common.core.model.response.IllegalAppListResponse;
import xyz.homapay.hampay.core.common.data.model.IllegalApp;
import xyz.homapay.hampay.core.common.exception.DatabaseException;
import xyz.homapay.hampay.core.server.service.IllegalAppsService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 10/27/15.
 * sima.ahmadvand@gmail.com
 */
public class IllegalAppListTest extends AbstractTestSuite {

    private IllegalAppsService illegalAppsServiceMock;

    @Before
    public void init() throws Exception {
        MuleEvent muleEvent = testEvent("");
        illegalAppsServiceMock = (IllegalAppsService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("illegalAppsService");
    }

    @Test
    public void testIllegalAppListSuccess() throws Exception {
        reset(illegalAppsServiceMock);
        expect(illegalAppsServiceMock.getAllIllegalApps()).andReturn(getIllegalAppList());
        replay(illegalAppsServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<IllegalAppListRequest> message = createIllegalAppListRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<IllegalAppListRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IllegalAppListFlow", event);
        verify(illegalAppsServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IllegalAppListResponse> response =
                gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IllegalAppListResponse>>() {
                }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(response.getService().getRequestUUID(), "834975ikjh3498908");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.ILLEGAL_APP_LIST);
        assertNotNull(response.getService().getIllegalAppList());
        assertEquals(response.getService().getIllegalAppList().get(0), "test1");
        assertEquals(response.getService().getIllegalAppList().get(1), "test2");
    }

    private RequestMessage<IllegalAppListRequest> createIllegalAppListRequest() {
        RequestMessage<IllegalAppListRequest> requestMessage = new RequestMessage<>();
        IllegalAppListRequest service = new IllegalAppListRequest();
        service.setRequestUUID("834975ikjh3498908");
        requestMessage.setService(service);
        return requestMessage;
    }

    private List<IllegalApp> getIllegalAppList() {
        List<IllegalApp> illegalApps = new ArrayList<>(2);
        IllegalApp illegalApp1 = new IllegalApp();
        illegalApp1.setName("test1");
        IllegalApp illegalApp2 = new IllegalApp();
        illegalApp2.setName("test2");
        illegalApps.add(illegalApp1);
        illegalApps.add(illegalApp2);
        return illegalApps;
    }

    @Test
    public void testIllegalAppListDatabaseException() throws Exception {
        reset(illegalAppsServiceMock);
        expect(illegalAppsServiceMock.getAllIllegalApps()).andThrow(new DatabaseException());
        replay(illegalAppsServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<IllegalAppListRequest> message = createIllegalAppListRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<IllegalAppListRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IllegalAppListFlow", event);
        verify(illegalAppsServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IllegalAppListResponse> response =
                gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IllegalAppListResponse>>() {
                }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.DATABASE_EXCEPTION);
        assertEquals(response.getService().getRequestUUID(), "834975ikjh3498908");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.ILLEGAL_APP_LIST);
        assertNull(response.getService().getIllegalAppList());
    }

    @Test
    public void testIllegalAppListRuntimeException() throws Exception {
        reset(illegalAppsServiceMock);
        expect(illegalAppsServiceMock.getAllIllegalApps()).andThrow(new RuntimeException());
        replay(illegalAppsServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        RequestMessage<IllegalAppListRequest> message = createIllegalAppListRequest();
        String jsonMessage = gson().toJson(message, new TypeToken<RequestMessage<IllegalAppListRequest>>() {
        }.getType());
        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("IllegalAppListFlow", event);
        verify(illegalAppsServiceMock);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<IllegalAppListResponse> response =
                gson().fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<IllegalAppListResponse>>() {
                }.getType());
        assertEquals(response.getService().getResultStatus(), ResultStatus.FAILURE);
        assertEquals(response.getService().getRequestUUID(), "834975ikjh3498908");
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.ILLEGAL_APP_LIST);
        assertNull(response.getService().getIllegalAppList());
    }

}
