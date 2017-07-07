package xyz.homapay.hampay.core.servermock;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.request.*;
import xyz.homapay.hampay.common.core.model.response.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Siavash Mahmoudpour
 */
public class UserProfileTest extends AbstractTestSuite {

    @Test
    public void testUserProfile() throws Exception {

        Type requestType = new TypeToken<RequestMessage<UserProfileRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createUserProfileRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("UserProfileFlow", event);
        assertNotNull(result.getMessage().getPayload());

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        Type responseType = new TypeToken<ResponseMessage<UserProfileResponse>>() {
        }.getType();
        ResponseMessage<UserProfileResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getUserProfile());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testChangePassCode() throws Exception {

        Type requestType = new TypeToken<RequestMessage<ChangePassCodeRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createChangePassCodeRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("ChangePassCodeFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<ChangePassCodeResponse>>() {
        }.getType();
        ResponseMessage<ChangePassCodeResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testChangeMemorableWordRequest() throws Exception {

        Type requestType = new TypeToken<RequestMessage<ChangeMemorableWordRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createChangeMemorableWordRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("ChangeMemorableWordFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<ChangeMemorableWordResponse>>() {
        }.getType();
        ResponseMessage<ChangeMemorableWordResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testVerifyAccountRequest() throws Exception {

        Type requestType = new TypeToken<RequestMessage<VerifyAccountRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createVerifyAccountRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("VerifyAccountFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<VerifyAccountResponse>>() {
        }.getType();
        ResponseMessage<VerifyAccountResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getTransferMoneyComment());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testVerifyTransferMoneyRequest() throws Exception {

        Type requestType = new TypeToken<RequestMessage<VerifyTransferMoneyRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createVerifyTransferMoneyRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("VerifyTransferMoneyFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<VerifyTransferMoneyResponse>>() {
        }.getType();
        ResponseMessage<VerifyTransferMoneyResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getRequestUUID());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    @Test
    public void testContactsHampayEnabled() throws Exception {

        Type requestType = new TypeToken<RequestMessage<ContactsHampayEnabledRequest>>() {
        }.getType();
        String jsonString = new Gson().toJson(createContactsHampayEnabledRequest(), requestType);

        MuleEvent event = testEvent(jsonString);
        MuleEvent result = runFlow("ContactsHampayEnabledFlow", event);
        assertNotNull(result.getMessage().getPayload());

        Type responseType = new TypeToken<ResponseMessage<ContactsHampayEnabledResponse>>() {
        }.getType();
        ResponseMessage<ContactsHampayEnabledResponse> response = new Gson().fromJson(result.getMessage().getPayloadAsString(), responseType);

        assertNotNull(response.getService());
        assertNotNull(response.getService().getContacts());
        assertEquals(ResultStatus.SUCCESS, response.getService().getResultStatus());
    }

    private RequestMessage<UserProfileRequest> createUserProfileRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<UserProfileRequest> message = new RequestMessage<UserProfileRequest>();
        message.setRequestHeader(header);
        UserProfileRequest request = new UserProfileRequest();
        request.setRequestUUID("1234");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<ChangePassCodeRequest> createChangePassCodeRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<ChangePassCodeRequest> message = new RequestMessage<ChangePassCodeRequest>();
        message.setRequestHeader(header);
        ChangePassCodeRequest request = new ChangePassCodeRequest();
        request.setRequestUUID("1234");
        request.setCurrentPassCode("12345");
        request.setNewPassCode("54321");
        request.setMemorableCode("Test Mem");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<ChangeMemorableWordRequest> createChangeMemorableWordRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<ChangeMemorableWordRequest> message = new RequestMessage<ChangeMemorableWordRequest>();
        message.setRequestHeader(header);
        ChangeMemorableWordRequest request = new ChangeMemorableWordRequest();
        request.setRequestUUID("1234");
        request.setCurrentMemorableWord("Test Mem");
        request.setNewMemorableWord("Test");
        request.setPassCode("12345");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<VerifyAccountRequest> createVerifyAccountRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<VerifyAccountRequest> message = new RequestMessage<VerifyAccountRequest>();
        message.setRequestHeader(header);
        VerifyAccountRequest request = new VerifyAccountRequest();
        request.setRequestUUID("1234");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<VerifyTransferMoneyRequest> createVerifyTransferMoneyRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<VerifyTransferMoneyRequest> message = new RequestMessage<VerifyTransferMoneyRequest>();
        message.setRequestHeader(header);
        VerifyTransferMoneyRequest request = new VerifyTransferMoneyRequest();
        request.setRequestUUID("1234");
        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private RequestMessage<ContactsHampayEnabledRequest> createContactsHampayEnabledRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        RequestMessage<ContactsHampayEnabledRequest> message = new RequestMessage<ContactsHampayEnabledRequest>();
        message.setRequestHeader(header);
        ContactsHampayEnabledRequest request = new ContactsHampayEnabledRequest();
        request.setRequestUUID("1234");
        request.setContacts(getContacts());

        message.setService(request);
        message.getService().getRequestUUID();

        return message;
    }

    private List<ContactDTO> getContacts() {
        List<ContactDTO> contacts = new ArrayList<ContactDTO>();

        ContactDTO contact1 = new ContactDTO();
        contact1.setCellNumber("09124267712");
        contact1.setDisplayName("Siavash Mahmoudpour");
        contacts.add(contact1);

        ContactDTO contact2 = new ContactDTO();
        contact2.setCellNumber("09129479928");
        contact2.setDisplayName("Hooman Amini");
        contacts.add(contact2);

        ContactDTO contact3 = new ContactDTO();
        contact3.setCellNumber("09123333333");
        contact3.setDisplayName("Ebrahim Pasbani");
        contacts.add(contact3);

        ContactDTO contact4 = new ContactDTO();
        contact4.setCellNumber("09122222222");
        contact4.setDisplayName("Sima Ahmadvand");
        contacts.add(contact4);

        ContactDTO contact5 = new ContactDTO();
        contact5.setCellNumber("09121111111");
        contact5.setDisplayName("Majid Zamani");
        contacts.add(contact5);

        return contacts;
    }

}
