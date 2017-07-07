package xyz.homapay.hampay.core.server.service;

import org.apache.commons.collections.CollectionUtils;
import xyz.homapay.hampay.common.core.model.request.BusinessPaymentRequest;
import xyz.homapay.hampay.common.core.model.request.IndividualPaymentRequest;
import xyz.homapay.hampay.common.core.model.response.dto.TransactionDTO;
import xyz.homapay.hampay.core.common.data.model.Business;
import xyz.homapay.hampay.core.common.data.model.Transaction;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.*;
import xyz.homapay.hampay.core.server.dao.TransactionDao;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;
import xyz.homapay.hampay.core.server.helper.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ebrahim Pasbani.
 */
public class TransactionService {

    private BusinessService businessService;
    private UserService userService;
    private TransactionDao transactionDao;
    private PaymentService paymentService;
    private PropertiesUtil propertiesUtil;
    private BillingService billingService;

    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public List<TransactionDTO> getListByUser(String userId, Integer pageSize, Integer pageNumber) throws DatabaseException, UserNotFoundException {
        List<TransactionDTO> result = new ArrayList<>();
        User user = userService.findActivatedUserByUserId(userId);
        if (userId != null) {
            List<Transaction> transactions = transactionDao.findTransactionRangeByUserId(userId, pageSize, pageNumber);
            if (CollectionUtils.isNotEmpty(transactions)) {
                for (Transaction trx : transactions) {
                    try {
                        result.add(fillTransactionDTOProperties(trx, user));
                    } catch (BusinessNotFoundException ignored) {

                    }
                }
            }
        }
        return result;
    }

    private TransactionDTO fillTransactionDTOProperties(Transaction tnx, User user) throws DatabaseException, UserNotFoundException, BusinessNotFoundException {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(tnx.getAmount());
        transactionDTO.setReference(tnx.getReference());
        transactionDTO.setTransactionDate(tnx.getTransactionDate());
        transactionDTO.setTransactionStatus(TransactionDTO.TransactionStatus.valueOf(tnx.getTransactionStatus().toString()));
        transactionDTO.setMessage(tnx.getMessage());
        transactionDTO.setFeeCharge(tnx.getFeeCharge());
        if (tnx.getRejectReason() != null)
            transactionDTO.setRejectReasonMessage(propertiesUtil.getRejectStatusMessage(tnx.getRejectReason()));
        if (tnx.getPersonType().equals(Transaction.PersonType.BUSINESS)) {
            transactionDTO.setPersonName(tnx.getDestinationAccount().getCustomer().getName());
            transactionDTO.setPersonType(TransactionDTO.PersonType.BUSINESS);
            transactionDTO.setBusinessCode(businessService.findBusinessByAccountId(tnx.getDestinationAccount().getId()).getIdentityCode());
            transactionDTO.setPhoneNumber(tnx.getDestinationAccount().getCustomer().getPhoneNumber());
            transactionDTO.setTransactionType(TransactionDTO.TransactionType.DEBIT);
        } else {
            transactionDTO.setPersonType(TransactionDTO.PersonType.INDIVIDUAL);
            if (user.getCustomer().getDefaultAccount().equals(tnx.getSourceAccount())) {
                transactionDTO.setPhoneNumber(tnx.getDestinationAccount().getCustomer().getPhoneNumber());
                transactionDTO.setPersonName(tnx.getDestinationAccount().getCustomer().getName());
                transactionDTO.setTransactionType(TransactionDTO.TransactionType.DEBIT);
            }
            if (user.getCustomer().getDefaultAccount().equals(tnx.getDestinationAccount())) {
                transactionDTO.setPhoneNumber(tnx.getSourceAccount().getCustomer().getPhoneNumber());
                transactionDTO.setTransactionType(TransactionDTO.TransactionType.CREDIT);
                transactionDTO.setPersonName(tnx.getSourceAccount().getCustomer().getName());

            }
        }
        return transactionDTO;
    }


    public Transaction createBusinessTransaction(User user, BusinessPaymentRequest request, Business business) throws DatabaseException {
        Transaction transaction = new Transaction();
        transaction.setReference(Util.createTransactionReferenceCode());
        transaction.setAmount(request.getAmount());
        transaction.setMessage(request.getMessage());
        transaction.setPersonType(Transaction.PersonType.BUSINESS);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionStatus(Transaction.TransactionStatus.INITIATING);
        transaction.setSourceAccount(user.getCustomer().getDefaultAccount());
        transaction.setDestinationAccount(business.getDefaultAccount());
        transactionDao.save(transaction);
        return transaction;
    }

    public void save(Transaction transaction) throws DatabaseException {
        transactionDao.save(transaction);
    }

    public void updateTransactionStatusToPending(Transaction transaction) throws DatabaseException {
        transaction.setTransactionStatus(Transaction.TransactionStatus.PENDING);
        transactionDao.save(transaction);
    }

    public Transaction createIndividualTransaction(User user, IndividualPaymentRequest request) throws DatabaseException, UserNotFoundException,
            UserNotEligibleToPayException, DestinationIsNotEligibleToPayException, PaymentIsNotInRangeException, FeeChargeNotFoundException {
        Transaction transaction = new Transaction();
        User destination = userService.findActivatedUserByCellNumber(request.getCellNumber());
        paymentService.checkRequestEligibilityToDoIndividualPayment(user, destination, request.getAmount());
        transaction.setReference(Util.createTransactionReferenceCode());
        transaction.setAmount(request.getAmount());
        transaction.setMessage(request.getMessage());
        transaction.setPersonType(Transaction.PersonType.INDIVIDUAL);
        transaction.setTransactionDate(new Date());
        transaction.setTransactionStatus(Transaction.TransactionStatus.INITIATING);
        transaction.setSourceAccount(user.getCustomer().getDefaultAccount());
        transaction.setDestinationAccount(destination.getCustomer().getDefaultAccount());
        transaction.setFeeCharge(billingService.calculateFeeCharge(user.getUserGroup().getBillingGroup(), request.getAmount()));
        transactionDao.save(transaction);
        return transaction;
    }

    public Transaction findTransactionByReferenceCode(String referenceCode) throws DatabaseException, TransactionNotFoundException {
        return transactionDao.findTransactionByReferenceCode(referenceCode);
    }


}
