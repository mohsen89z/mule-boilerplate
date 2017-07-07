package xyz.homapay.hampay.smsgateway.service;

import xyz.homapay.hampay.smsgateway.model.req.SensSMSReqDTO;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;

/**
 * Created by sima on 7/6/15.
 */
public interface MiddleEastSMSGatewayService {

    SendSMSResDTO sendSMS(SensSMSReqDTO smsReqDTO);
}
