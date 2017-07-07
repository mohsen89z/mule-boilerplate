package xyz.homapay.hampay.core.test.flows.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.config.spring.SpringRegistry;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import org.springframework.context.ApplicationContext;
import xyz.homapay.hampay.common.common.ServiceDefinition;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.request.RegistrationCredentialsRequest;
import xyz.homapay.hampay.common.core.model.response.RegistrationCredentialsResponse;
import xyz.homapay.hampay.core.common.data.dto.IdpUserDTO;
import xyz.homapay.hampay.core.server.service.RegistrationService;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 8/19/15.
 */
public class RegCredentialTest extends AbstractTestSuite {

    private RegistrationService registrationServiceMock;

    @Before
    public void init() throws Exception {

        MuleEvent muleEvent = testEvent("");
        registrationServiceMock = (RegistrationService) ((ApplicationContext) muleEvent.getMuleContext()
                .getRegistry().lookupObject(SpringRegistry.SPRING_APPLICATION_CONTEXT)).getBean("registrationService");
    }

    @Test
    public void testRegistrationCredentialEntryFlow() throws Exception {
        RequestMessage<RegistrationCredentialsRequest> request = createRequest();
        reset(registrationServiceMock);
        expect(registrationServiceMock.createIdpUserDTO(isA(RegistrationCredentialsRequest.class))).andReturn(createIdpUserDTO());
        registrationServiceMock.activateUser(isA(RegistrationCredentialsRequest.class));
        replay(registrationServiceMock);
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        mockLogoutSuccess();
        mockIDPReadUserNotFound("0083519076");
        mockCreateSuccessUser();
        mockLogoutSuccess();

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(request, new TypeToken<RequestMessage<RegistrationCredentialsRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("RegistrationCredentialEntryFlow", event);
        verify(registrationServiceMock);

        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<RegistrationCredentialsResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<RegistrationCredentialsResponse>>() {
        }.getType());

        assertEquals(response.getService().getRequestUUID(), "34897598375");
        assertEquals(response.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(response.getService().getServiceDefinition(), ServiceDefinition.REGISTRATION_CREDENTIALS);

    }

    private RequestMessage<RegistrationCredentialsRequest> createRequest() {
        RequestMessage<RegistrationCredentialsRequest> requestMessage = new RequestMessage<>();
        RequestHeader header = new RequestHeader();
        header.setVersion("1.0-PA");
        header.setAuthToken("000909");
        RegistrationCredentialsRequest service = new RegistrationCredentialsRequest();
        service.setRequestUUID("34897598375");
        service.setDeviceId("389476538765");
        service.setInstallationToken("746583746");
        service.setMemorableKey("test");
        service.setPassCode("12345");
        service.setUserIdToken("1298453793745345");
        requestMessage.setRequestHeader(header);
        requestMessage.setService(service);
        return requestMessage;
    }

    private IdpUserDTO createIdpUserDTO() {
        IdpUserDTO idpUserDTO = new IdpUserDTO();
        idpUserDTO.setUsername("0083519076");
        idpUserDTO.setUserPassword("88888888888888");
        return idpUserDTO;
    }


}
