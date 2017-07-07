package xyz.homapay.hampay.core.common.data.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Version;

import java.util.Date;

/**
 * Created by sima on 9/27/15.
 * sima.ahmadvand@gmail.com
 */
@Entity(value = "notification", noClassnameStored = true)
public class Notification extends BaseEntity {

    private String message;
    private Date dateTime;
    private String machineName;
    private NotificationStatus notificationStatus;
    @Version
    private Long version;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
