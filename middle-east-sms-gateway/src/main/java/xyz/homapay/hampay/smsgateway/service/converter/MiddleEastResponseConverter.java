package xyz.homapay.hampay.smsgateway.service.converter;

import xyz.homapay.hampay.smsgateway.model.SMSResponseStatus;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;

/**
 * Created by sima on 2/9/2015.
 */
public class MiddleEastResponseConverter {

    public SendSMSResDTO convertSendSMSResponseToResponseDTO(String response) {
        SendSMSResDTO sendSMSResDTO = new SendSMSResDTO();
        if (Character.isDigit(response.charAt(0)))
            sendSMSResDTO.setResponseStatus(SMSResponseStatus.SUCCESS);
        else sendSMSResDTO.setResponseStatus(SMSResponseStatus.FAILURE);
        sendSMSResDTO.setExactResult(response);
        return sendSMSResDTO;
    }

    public SendSMSResDTO getFailedSendSMSDTO() {
        SendSMSResDTO sendSMSResDTO = new SendSMSResDTO();
        sendSMSResDTO.setResponseStatus(SMSResponseStatus.FAILURE);
        return sendSMSResDTO;
    }

    public SendSMSResDTO getTimeoutSendSMSDTO() {
        SendSMSResDTO sendSMSResDTO = new SendSMSResDTO();
        sendSMSResDTO.setResponseStatus(SMSResponseStatus.TIME_OUT);
        return sendSMSResDTO;

    }
}
