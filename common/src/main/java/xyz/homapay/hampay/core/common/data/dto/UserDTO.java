package xyz.homapay.hampay.core.common.data.dto;

/**
 * Created by Ebrahim Pasbani.
 */
public class UserDTO {
    private Boolean valid = Boolean.FALSE;
    private String userId;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
