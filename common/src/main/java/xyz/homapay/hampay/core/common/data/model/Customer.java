package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */

//@Entity(value = "",noClassnameStored = true)
//@Polymorphic
public class Customer extends BaseEntity {

    @Reference
    private List<Account> accounts;
    @Reference
    private Account defaultAccount;
    private String phoneNumber;
    private String identityCode;
    private String name;

    public List<Account> getAccounts() {
        if (accounts == null)
            accounts = new ArrayList<Account>();
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Account defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
