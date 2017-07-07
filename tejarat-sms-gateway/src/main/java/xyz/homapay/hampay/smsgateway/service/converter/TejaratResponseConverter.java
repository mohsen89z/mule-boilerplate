package xyz.homapay.hampay.smsgateway.service.converter;

import xyz.homapay.hampay.smsgateway.model.SMSResponseStatus;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;

/**
 * Created by sima on 2/9/2015.
 */
public class TejaratResponseConverter {

    public SendSMSResDTO convertSendSMSResponseToResponseDTO(String response) {
        SendSMSResDTO sendSMSResDTO = new SendSMSResDTO();
        if (response.startsWith("Error"))
            sendSMSResDTO.setResponseStatus(SMSResponseStatus.FAILURE);
        else sendSMSResDTO.setResponseStatus(SMSResponseStatus.SUCCESS);
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
