package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

/**
 * Created by sima on 8/11/15.
 */
@Entity(value = "verify_history", noClassnameStored = true)
public class VerificationHistory extends BaseEntity {

    private Integer amount;
    private Date actionDate;
    private boolean settled;
    @Property("account")
    private String accountNumber;
    @Reference
    private User user;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
