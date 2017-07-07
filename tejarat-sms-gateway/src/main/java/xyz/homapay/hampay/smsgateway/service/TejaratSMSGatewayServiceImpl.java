package xyz.homapay.hampay.smsgateway.service;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import xyz.homapay.hampay.smsgateway.TejaratSMSGatewayUtils;
import xyz.homapay.hampay.smsgateway.model.remote.SmsLocator;
import xyz.homapay.hampay.smsgateway.model.remote.SmsSoap_PortType;
import xyz.homapay.hampay.smsgateway.model.req.SensSMSReqDTO;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;
import xyz.homapay.hampay.smsgateway.service.converter.TejaratResponseConverter;

import javax.xml.rpc.ServiceException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by sima on 2/9/2015.
 */
public class TejaratSMSGatewayServiceImpl implements TejaratSMSGatewayService {

    private SmsSoap_PortType service;
    private TejaratSMSGatewayUtils utils = new TejaratSMSGatewayUtils();
    final static Logger logger = Logger.getLogger(TejaratSMSGatewayServiceImpl.class);


    private TejaratResponseConverter responseConverter = new TejaratResponseConverter();

    public TejaratSMSGatewayServiceImpl() {
        try {
            service = new SmsLocator().getsmsSoap12(new URL(utils.getSmsURL()));
        } catch (ServiceException | MalformedURLException e) {
            logger.error(new StringBuilder("There is a problem in fetching WSDL file").append(e.getMessage()));
        }
    }

    public SendSMSResDTO sendSMS(SensSMSReqDTO smsReqDTO) {
        SendSMSResDTO sendSMSResDTO;
        try {
            if (logger.isInfoEnabled())
                logger.info("Send SMS service is running ...");
            String response = service.doSendSMS(utils.getUsername(), utils.getPassword(), utils.getNumber(), smsReqDTO.getCellNumber(), smsReqDTO.getSmsToken(), false, false, false, "");
            if (logger.isInfoEnabled())
                logger.info(new StringBuilder("SMS response is :").append(response));
            sendSMSResDTO = responseConverter.convertSendSMSResponseToResponseDTO(response);
        } catch (AxisFault e) {
            if (e.getCause() instanceof UnknownHostException || e.getCause() instanceof ConnectException) {
                logger.error(new StringBuilder("SMS host is not available:").append(e.getMessage()));
                sendSMSResDTO = responseConverter.getTimeoutSendSMSDTO();
            } else
                sendSMSResDTO = responseConverter.getFailedSendSMSDTO();
        } catch (Exception e) {
            logger.error(new StringBuilder("An unexpected exception occurred: ").append(e.getMessage()));
            sendSMSResDTO = responseConverter.getFailedSendSMSDTO();
        }
        return sendSMSResDTO;
    }
}
