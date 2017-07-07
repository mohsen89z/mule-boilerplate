package xyz.homapay.hampay.smsgateway.service;

import xyz.homapay.hampay.smsgateway.model.req.SensSMSReqDTO;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;

/**
 * Created by sima on 2/9/2015.
 */
public interface TejaratSMSGatewayService {

    SendSMSResDTO sendSMS(SensSMSReqDTO smsReqDTO);
}
