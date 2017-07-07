package xyz.homapay.hampay.core.common.data.dto;

/**
 * Created by sima on 6/29/15.
 */
public class DepositAmountDTO {

    private Integer amount;
    private String hampayAccount;
    private String userAccount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getHampayAccount() {
        return hampayAccount;
    }

    public void setHampayAccount(String hampayAccount) {
        this.hampayAccount = hampayAccount;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
