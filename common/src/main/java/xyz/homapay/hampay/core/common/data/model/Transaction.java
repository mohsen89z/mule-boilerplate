package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import xyz.homapay.hampay.common.switchbay.model.SwitchResponseStatus;

import java.util.Date;

/**
 * @author Siavash Mahmoudpour
 */

@Entity(value = "transactions", noClassnameStored = true)
public class Transaction extends BaseEntity {

    public enum TransactionStatus {
        INITIATING, SUCCESS, FAILURE, PENDING
    }

    public enum PersonType {
        INDIVIDUAL, BUSINESS
    }

    @Reference
    private Account sourceAccount;
    @Reference
    private Account destinationAccount;
    private Long amount;
    private long feeCharge;
    private Date transactionDate;
    private TransactionStatus transactionStatus;
    private PersonType personType;
    private String message;
    private String reference;
    private SwitchResponseStatus rejectReason;


    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public SwitchResponseStatus getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(SwitchResponseStatus rejectReason) {
        this.rejectReason = rejectReason;
    }

    public long getFeeCharge() {
        return feeCharge;
    }

    public void setFeeCharge(long feeCharge) {
        this.feeCharge = feeCharge;
    }
}
