package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * @author Siavash Mahmoudpour
 */

@Entity(value = "accounts", noClassnameStored = true)
public class Account extends BaseEntity {

    private String accountNumber;

    @Reference
    private Bank bank;

    @Reference
    private Customer customer;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNumber != null ? !accountNumber.equals(account.accountNumber) : account.accountNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return accountNumber != null ? accountNumber.hashCode() : 0;
    }
}
