package xyz.homapay.hampay.core.common.data.dto;

/**
 * @author Siavash Mahmoudpour
 */
public class IdpUserDTO {

    private String username;
    private String userPassword;
    private String email;

    public IdpUserDTO() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userpassword) {
        this.userPassword = userpassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
