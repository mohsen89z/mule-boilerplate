package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Created by Ebrahim Pasbani.
 */
@Entity(noClassnameStored = true, value = "user_acknowledgment")
public class IdentityAcknowledgment extends BaseEntity {
    private String userIdToken;
    private String deviceId;
    private String imei;
    private String ip;
    private Date confirmDate;

    public String getUserIdToken() {
        return userIdToken;
    }

    public void setUserIdToken(String userIdToken) {
        this.userIdToken = userIdToken;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }


}
