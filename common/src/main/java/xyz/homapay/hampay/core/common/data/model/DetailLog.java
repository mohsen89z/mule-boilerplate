package xyz.homapay.hampay.core.common.data.model;

import java.util.Date;

/**
 * @author Siavash Mahmoudpour
 */
public class DetailLog {

    private Date date;
    private String serviceName;
    private String userId;
    private Object messagePayload;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getMessagePayload() {
        return messagePayload;
    }

    public void setMessagePayload(Object messagePayload) {
        this.messagePayload = messagePayload;
    }
}
