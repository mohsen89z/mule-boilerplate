package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.annotations.Version;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;

import java.util.Date;
import java.util.List;

/**
 * @author Siavash Mahmoudpour
 */

@Entity(value = "users", noClassnameStored = true)
public class User extends BaseEntity {

    public enum RegistrationStep {
        ENTRY_PASSED,
        SMS_TOKEN_SENT,
        SMS_TOKEN_VERIFIED,
        USER_DATA_FETCHED,
        DEPOSIT_AMOUNT_GENERATED,
        ACCOUNT_XFER_VERIFIED,
        USER_DATA_CONFIRMED,
        USER_ACTIVATED,
        USER_DEACTIVATED
    }

    public enum BindingStatus {
        LINK,
        UNLINK
    }

    @Reference
    private IndividualCustomer customer;
    private String userId;
    private String userIdToken;
    private String mobileNo;
    private Date registrationDate;
    private Date registrationExpiryDate;
    private boolean isActive;
    private Date activationDate;
    private Date tacAcceptDate;
    private Date lastLoginDate;
    private Date recentLoginDate;
    private String smsToken;
    private String email;
    private UserVerificationStatus verificationStatus;
    private RegistrationStep registrationStep;
    private BindingStatus bindingStatus;
    @Reference
    private UserGroup userGroup;
    @Version
    private Long version;
    @Reference
    private List<UserDevice> devices;
    @Indexed(unique = true,sparse = true)
    private Long linkedNC;

    public UserDevice getFirstActiveDevice() {
        if (devices != null && devices.size() > 0)
            for (UserDevice device : devices) {
                if (device.isActive())
                    return device;
            }
        return null;
    }

    public String getUserIdToken() {
        return userIdToken;
    }

    public void setUserIdToken(String userIdToken) {
        this.userIdToken = userIdToken;
    }

    public IndividualCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(IndividualCustomer customer) {
        this.customer = customer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationExpiryDate() {
        return registrationExpiryDate;
    }

    public void setRegistrationExpiryDate(Date registrationExpiryDate) {
        this.registrationExpiryDate = registrationExpiryDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getTacAcceptDate() {
        return tacAcceptDate;
    }

    public void setTacAcceptDate(Date tacAcceptDate) {
        this.tacAcceptDate = tacAcceptDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public List<UserDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<UserDevice> devices) {
        this.devices = devices;
    }

    public String getSmsToken() {
        return smsToken;
    }

    public void setSmsToken(String smsToken) {
        this.smsToken = smsToken;
    }

    public UserVerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(UserVerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public RegistrationStep getRegistrationStep() {
        return registrationStep;
    }

    public void setRegistrationStep(RegistrationStep registrationStep) {
        this.registrationStep = registrationStep;
    }

    public Date getRecentLoginDate() {
        return recentLoginDate;
    }

    public void setRecentLoginDate(Date recentLoginDate) {
        this.recentLoginDate = recentLoginDate;
    }

    public BindingStatus getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(BindingStatus bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getLinkedNC() {
        return linkedNC;
    }

    public void setLinkedNC(Long linkedNC) {
        this.linkedNC = linkedNC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isActive != user.isActive) return false;
        if (bindingStatus != user.bindingStatus) return false;
        if (mobileNo != null ? !mobileNo.equals(user.mobileNo) : user.mobileNo != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (registrationStep != user.registrationStep) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userIdToken != null ? !userIdToken.equals(user.userIdToken) : user.userIdToken != null) return false;
        if (verificationStatus != user.verificationStatus) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userIdToken != null ? userIdToken.hashCode() : 0);
        result = 31 * result + (mobileNo != null ? mobileNo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (verificationStatus != null ? verificationStatus.hashCode() : 0);
        result = 31 * result + (registrationStep != null ? registrationStep.hashCode() : 0);
        result = 31 * result + (bindingStatus != null ? bindingStatus.hashCode() : 0);
        return result;
    }
}
