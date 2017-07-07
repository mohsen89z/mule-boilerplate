package xyz.homapay.hampay.core.server.service;

import org.apache.log4j.Logger;
import xyz.homapay.hampay.core.common.data.dto.SupportedBanks;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.common.exception.InvalidBankCodeException;
import xyz.homapay.hampay.core.common.exception.SMSNotSentException;
import xyz.homapay.hampay.core.common.exception.SMSTimeoutException;
import xyz.homapay.hampay.core.server.helper.PropertiesUtil;
import xyz.homapay.hampay.smsgateway.model.SMSResponseStatus;
import xyz.homapay.hampay.smsgateway.model.req.SensSMSReqDTO;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;
import xyz.homapay.hampay.smsgateway.service.MiddleEastSMSGatewayServiceImpl;
import xyz.homapay.hampay.smsgateway.service.TejaratSMSGatewayServiceImpl;

import java.util.List;

/**
 * Created by sima on 2/9/2015.
 */
public class SMSService {

    private final static Logger logger = Logger.getLogger(SMSService.class);
    private PropertiesUtil propertiesUtil;

    public void setPropertiesUtil(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    public void sendSMS(String smsToken, User user) throws InvalidBankCodeException, SMSTimeoutException, SMSNotSentException {
        if (!isUserNumberInBlackList(user.getMobileNo())) {
            int i = 0;
            SendSMSResDTO resDTO;
            do {
                if (i != 0)
                    sleep();
                resDTO = sendSMSBasedOnBank(smsToken, user);
                if (resDTO.getResponseStatus() == SMSResponseStatus.SUCCESS)
                    return;
                i++;

            } while (i < 3);
            checkSentSMSStatus(resDTO);
        }
    }

    private boolean isUserNumberInBlackList(String mobileNo) {
        List<String> blackListNumbers = propertiesUtil.getSMSBlackListNumbers();
        for (String number : blackListNumbers) {
            if (mobileNo.startsWith(number))
                return true;
        }
        return false;
    }

    private SendSMSResDTO sendSMSBasedOnBank(String smsToken, User user) throws InvalidBankCodeException {
        if (user.getCustomer().getDefaultAccount().getBank().getCode().equals(SupportedBanks.TEJARAT.getCode())) {
            return new TejaratSMSGatewayServiceImpl().sendSMS(createSendSMSRequestDTO(smsToken, user.getMobileNo()));
        } else if (user.getCustomer().getDefaultAccount().getBank().getCode().equals(SupportedBanks.MIDDLE_EAST.getCode())) {
            return new MiddleEastSMSGatewayServiceImpl().sendSMS(createSendSMSRequestDTO(smsToken, user.getMobileNo()));
        } else throw new InvalidBankCodeException();
    }

    private void checkSentSMSStatus(SendSMSResDTO sendSMSResDTO) throws SMSTimeoutException, SMSNotSentException {
        if (SMSResponseStatus.TIME_OUT == sendSMSResDTO.getResponseStatus())
            throw new SMSTimeoutException();
        else
            throw new SMSNotSentException();
    }

    public SensSMSReqDTO createSendSMSRequestDTO(String smsToken, String cellNumber) {
        SensSMSReqDTO reqDTO = new SensSMSReqDTO();
        reqDTO.setCellNumber(cellNumber);
        reqDTO.setSmsToken(smsToken);
        return reqDTO;
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            if (logger.isInfoEnabled())
                logger.info("Thread sleeping was interrupted by an external resource");
        }
    }
}
