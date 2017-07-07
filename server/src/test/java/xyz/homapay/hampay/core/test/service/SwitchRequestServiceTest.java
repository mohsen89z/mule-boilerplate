package xyz.homapay.hampay.core.test.service;

import org.junit.Test;
import xyz.homapay.hampay.common.common.ServiceDefinition;
import xyz.homapay.hampay.common.common.request.RequestMessage;
import xyz.homapay.hampay.common.switchbay.model.request.PaymentRequest;
import xyz.homapay.hampay.core.common.data.model.Account;
import xyz.homapay.hampay.core.common.data.model.Bank;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.server.service.switchbay.SwitchRequestService;
import xyz.homapay.hampay.core.test.TestUtil;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sima on 8/18/15.
 */
public class SwitchRequestServiceTest {

    private SwitchRequestService switchRequestService = new SwitchRequestService();

    @Test
    public void testCreateSwitchPaymentRequestForIndividual() throws Exception {
        RequestMessage<PaymentRequest> requestMessage = switchRequestService.createSwitchPaymentRequestForIndividual(TestUtil.createUser1(), createTransaction());
        assertNotNull(requestMessage);
        assertNotNull(requestMessage.getService());
        assertNotNull(requestMessage.getRequestHeader());
        assertEquals(requestMessage.getService().getAmount(), Long.valueOf(10000));
        assertEquals(requestMessage.getService().getSourceAccount().getAccountNumber(), "55555/22/566966");
        assertEquals(requestMessage.getService().getSourceAccount().getBankCode(), "18");
        assertEquals(requestMessage.getService().getDestinationAccount().getAccountNumber(), "568905984");
        assertEquals(requestMessage.getService().getDestinationAccount().getBankCode(), "78");
        assertEquals(requestMessage.getService().getTransactionId(), "HP-12232498323");
        assertEquals(requestMessage.getService().getServiceDefinition(), ServiceDefinition.SWITCH_PAYMENT);
        assertEquals(requestMessage.getService().getNationalId(), "0083519076");
        assertNotNull(requestMessage.getService().getRequestUUID());
    }

    private Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(Transaction.TransactionStatus.INITIATING);
        transaction.setAmount(10000l);
        transaction.setMessage("test");
        transaction.setPersonType(Transaction.PersonType.INDIVIDUAL);
        transaction.setReference("HP-12232498323");
        transaction.setTransactionDate(new Date());
        transaction.setDestinationAccount(new Account());
        transaction.getDestinationAccount().setAccountNumber("568905984");
        transaction.getDestinationAccount().setBank(new Bank());
        transaction.getDestinationAccount().getBank().setCode("78");
        transaction.getDestinationAccount().getBank().setName("بانک تجارت");
        transaction.setSourceAccount(new Account());
        transaction.getSourceAccount().setAccountNumber("55555/22/566966");
        transaction.getSourceAccount().setBank(new Bank());
        transaction.getSourceAccount().getBank().setCode("18");
        transaction.getSourceAccount().getBank().setName("بانک تجارت");
        return transaction;
    }
}
