package xyz.homapay.hampay.core.test.resProvider;

import org.junit.Test;
import xyz.homapay.hampay.common.common.ServiceDefinition;
import xyz.homapay.hampay.common.common.response.ResponseMessage;
import xyz.homapay.hampay.common.common.response.ResultStatus;
import xyz.homapay.hampay.common.core.model.response.IndividualPaymentResponse;
import xyz.homapay.hampay.core.server.response.PaymentResponseProvider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sima on 8/18/15.
 */
public class PaymentResponseProviderTest {

    private PaymentResponseProvider responseProvider = new PaymentResponseProvider();

    @Test
    public void testCreateIndividualPaymentResponse() throws Exception {
        ResponseMessage<IndividualPaymentResponse> responseMessage = responseProvider.createIndividualPaymentResponse("237864823764", "HP-78236472342");
        assertNotNull(responseMessage.getService());
        assertEquals(responseMessage.getService().getServiceDefinition(), ServiceDefinition.INDIVIDUAL_PAYMENT);
        assertEquals(responseMessage.getService().getRequestUUID(), "237864823764");
        assertEquals(responseMessage.getService().getResultStatus(), ResultStatus.SUCCESS);
        assertEquals(responseMessage.getService().getRefCode(), "HP-78236472342");
    }
}
