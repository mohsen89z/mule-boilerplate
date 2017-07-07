package xyz.homapay.hampay.core.test.service;

import org.junit.Before;
import org.junit.Test;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentRequest;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentRequest;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.*;
import xyz.homapay.hampay.core.server.dao.TransactionDao;
import xyz.homapay.hampay.core.server.service.PaymentService;
import xyz.homapay.hampay.core.server.service.TransactionService;
import xyz.homapay.hampay.core.server.service.UserService;
import xyz.homapay.hampay.core.test.TestUtil;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.*;

/**
 * Created by sima on 8/18/15.
 */
public class TransactionServiceTest {

    private TransactionService transactionService = new TransactionService();
    private TransactionDao transactionDao;
    private UserService userService;

    @Before
    public void init() throws Exception {
        transactionDao = createMock(TransactionDao.class);
        userService = createMock(UserService.class);
        transactionService.setTransactionDao(transactionDao);
        transactionService.setUserService(userService);
        transactionService.setPaymentService(new PaymentService());
    }

    @Test
    public void testCreateBusinessTransaction() throws Exception {
        reset(transactionDao);
        transactionDao.save(isA(Transaction.class));
        replay(transactionDao);
        User user = TestUtil.createUser1();
        Business business = TestUtil.createBusiness();
        Transaction transaction = transactionService.createBusinessTransaction(user, createBusinessPaymentRequest(), business);
        verify(transactionDao);
        assertEquals(transaction.getAmount(), Long.valueOf(100));
        assertEquals(transaction.getMessage(), "test");
        assertEquals(transaction.getSourceAccount(), user.getCustomer().getDefaultAccount());
        assertEquals(transaction.getDestinationAccount(), business.getDefaultAccount());
        assertEquals(transaction.getPersonType(), Transaction.PersonType.BUSINESS);
        assertEquals(transaction.getTransactionStatus(), Transaction.TransactionStatus.INITIATING);
        assertNotNull(transaction.getTransactionDate());
    }


    private BusinessPaymentRequest createBusinessPaymentRequest() {
        BusinessPaymentRequest request = new BusinessPaymentRequest();
        request.setBusinessCode("1099");
        request.setRequestUUID("101010101010");
        request.setMessage("test");
        request.setAmount(100l);
        return request;
    }

    @Test
    public void testCreateIndividualTransaction() throws Exception {
        User user = TestUtil.createUser1();
        User destination = TestUtil.createUser2();
        reset(transactionDao);
        reset(userService);
        transactionDao.save(isA(Transaction.class));
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(destination);
        replay(transactionDao);
        replay(userService);
        Transaction transaction = transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(transactionDao);
        verify(userService);
        assertEquals(transaction.getAmount(), Long.valueOf(100000));
        assertEquals(transaction.getMessage(), "test");
        assertEquals(transaction.getSourceAccount(), user.getCustomer().getDefaultAccount());
        assertEquals(transaction.getDestinationAccount(), destination.getCustomer().getDefaultAccount());
        assertEquals(transaction.getPersonType(), Transaction.PersonType.INDIVIDUAL);
        assertEquals(transaction.getTransactionStatus(), Transaction.TransactionStatus.INITIATING);
        assertNotNull(transaction.getTransactionDate());
    }

    private IndividualPaymentRequest createIndividualPaymentRequest() {
        IndividualPaymentRequest request = new IndividualPaymentRequest();
        request.setCellNumber("09125252282");
        request.setRequestUUID("101010101010");
        request.setMessage("test");
        request.setAmount(100000l);
        return request;
    }

    @Test(expected = DatabaseException.class)
    public void testCreateIndividualTransactionDatabaseExceptionTest() throws Exception {
        User user = TestUtil.createUser1();
        User destination = TestUtil.createUser2();
        reset(transactionDao);
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(destination);
        transactionDao.save(isA(Transaction.class));
        expectLastCall().andThrow(new DatabaseException());
        replay(transactionDao);
        replay(userService);
        transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(transactionDao);
        verify(userService);
    }

    @Test(expected = UserNotFoundException.class)
    public void testCreateIndividualTransactionUserNotFoundExceptionTest() throws Exception {
        User user = TestUtil.createUser1();
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andThrow(new UserNotFoundException());
        replay(userService);
        transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(userService);
    }

    @Test(expected = UserNotEligibleToPayException.class)
    public void testCreateIndividualTransactionIllegalUserExceptionTest1() throws Exception {
        User user = TestUtil.createUser1();
        user.setIsActive(false);
        User destination = TestUtil.createUser2();
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(destination);
        replay(userService);
        transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(userService);
    }

    @Test(expected = UserNotEligibleToPayException.class)
    public void testCreateIndividualTransactionIllegalUserExceptionTest2() throws Exception {
        User user = TestUtil.createUser1();
        user.setVerificationStatus(UserVerificationStatus.VERIFIED);
        User destination = TestUtil.createUser2();
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(destination);
        replay(userService);
        transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(userService);
    }

    @Test(expected = DestinationIsNotEligibleToPayException.class)
    public void testCreateIndividualTransactionIllegalDestinationExceptionTest() throws Exception {
        User user = TestUtil.createUser1();
        User destination = TestUtil.createUser2();
        destination.setIsActive(false);
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(destination);
        replay(userService);
        transactionService.createIndividualTransaction(user, createIndividualPaymentRequest());
        verify(userService);
    }

    @Test(expected = PaymentIsNotInRangeException.class)
    public void testCreateIndividualTransactionIllegalAmountExceptionTest() throws Exception {
        IndividualPaymentRequest request = createIndividualPaymentRequest();
        request.setAmount(1l);
        reset(userService);
        expect(userService.findActivatedUserByCellNumber("09125252282")).andReturn(TestUtil.createUser2());
        replay(userService);
        transactionService.createIndividualTransaction(TestUtil.createUser1(), request);
        verify(userService);
    }

}
