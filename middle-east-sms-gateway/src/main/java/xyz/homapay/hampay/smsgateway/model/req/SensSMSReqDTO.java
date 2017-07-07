package xyz.homapay.hampay.smsgateway.model.req;

import java.io.Serializable;

/**
 * Created by sima on 2/9/2015.
 */
public class SensSMSReqDTO implements Serializable {

    private String smsToken;
    private String cellNumber;

    public String getSmsToken() {
        return smsToken;
    }

    public void setSmsToken(String smsToken) {
        this.smsToken = smsToken;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }
}
