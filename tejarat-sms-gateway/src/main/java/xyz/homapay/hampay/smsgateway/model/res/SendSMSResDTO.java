package xyz.homapay.hampay.smsgateway.model.res;

import xyz.homapay.hampay.smsgateway.model.SMSResponseStatus;

import java.io.Serializable;

/**
 * Created by sima on 2/9/2015.
 */
public class SendSMSResDTO implements Serializable {

    private SMSResponseStatus responseStatus;
    private String exactResult;

    public SMSResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(SMSResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getExactResult() {
        return exactResult;
    }

    public void setExactResult(String exactResult) {
        this.exactResult = exactResult;
    }
}
