package xyz.homapay.hampay.core.test.flows.contact;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.modules.interceptor.processors.MuleMessageTransformer;
import xyz.homapay.hampay.common.common.request.RequestHeader;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.common.core.model.request.ContactsHampayEnabledRequest;
import xyz.homapay.hampay.common.core.model.response.ContactsHampayEnabledResponse;
import xyz.homapay.hampay.core.common.data.model.IndividualCustomer;
import xyz.homapay.hampay.core.server.data.DbConnection;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Ebrahim Pasbani.
 */
public class HampayEnabledTest extends AbstractTestSuite {
    private ContactDTO contact1 = null;
    private ContactDTO contact2 = null;
    private ContactDTO contact3 = null;

    @Before
    public void init() throws IOException {
        contact1 = new ContactDTO();
        contact1.setCellNumber("00989129912091");
        contact1.setDisplayName("Mr 1");

        contact2 = new ContactDTO();
        contact2.setCellNumber("00989129912092");
        contact2.setDisplayName("Mr 2");

        contact3 = new ContactDTO();
        contact3.setCellNumber("00989129912093");
        contact3.setDisplayName("Mr 3");


        Datastore ds = DbConnection.datastore();

        List<String> numbers = new ArrayList<String>(3);
        numbers.add(contact1.getCellNumber());
        numbers.add(contact2.getCellNumber());
        numbers.add(contact3.getCellNumber());

        Query<IndividualCustomer> query = DbConnection.datastore().find(IndividualCustomer.class);
        query.field("cellNumber").hasAnyOf(numbers);
        ds.delete(query);

        IndividualCustomer customer = new IndividualCustomer();
        customer.setPhoneNumber(contact1.getCellNumber());
        customer.setName(contact1.getDisplayName());
        ds.save(customer);

        customer = new IndividualCustomer();
        customer.setPhoneNumber(contact3.getCellNumber());
        customer.setName(contact3.getDisplayName());
        ds.save(customer);

    }

    @Test
    public void testHampayEnabledContacts() throws Exception {
        whenMessageProcessor("outbound-endpoint").ofNamespace("amqp").thenApply(new MuleMessageTransformer() {
            public MuleMessage transform(MuleMessage muleMessage) {
                return muleMessage;
            }
        });

        Gson gson = new Gson();
        RequestMessage<ContactsHampayEnabledRequest> message = createRequest();
        String jsonMessage = gson.toJson(message, new TypeToken<RequestMessage<ContactsHampayEnabledRequest>>() {
        }.getType());

        MuleEvent event = testEvent(jsonMessage);
        MuleEvent result = runFlow("ContactsHampayEnabledFlow", event);
        assertNotNull(result.getMessage().getPayload());

        ResponseMessage<ContactsHampayEnabledResponse> response = gson.fromJson(result.getMessage().getPayloadAsString(), new TypeToken<ResponseMessage<ContactsHampayEnabledResponse>>() {
        }.getType());

        assertNotNull(response.getService().getContacts());
        assertEquals(2, response.getService().getContacts().size());
    }

    private RequestMessage<ContactsHampayEnabledRequest> createRequest() {
        RequestHeader header = new RequestHeader();
        header.setAuthToken("008ewe");
        header.setVersion("1.0-PA");

        List<ContactDTO> contacts = new ArrayList<ContactDTO>(3);
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        ContactsHampayEnabledRequest req = null;
        req = new ContactsHampayEnabledRequest();
        req.setContacts(contacts);

        RequestMessage<ContactsHampayEnabledRequest> message = new RequestMessage<ContactsHampayEnabledRequest>();
        message.setService(req);
        message.setRequestHeader(header);

        return message;
    }
}
