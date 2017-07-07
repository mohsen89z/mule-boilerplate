package xyz.homapay.hampay.smsgateway.service;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import xyz.homapay.hampay.smsgateway.MiddleEastSMSGatewayUtils;
import xyz.homapay.hampay.smsgateway.model.remote.ServiceLocator;
import xyz.homapay.hampay.smsgateway.model.remote.ServiceSoap_PortType;
import xyz.homapay.hampay.smsgateway.model.req.SensSMSReqDTO;
import xyz.homapay.hampay.smsgateway.model.res.SendSMSResDTO;
import xyz.homapay.hampay.smsgateway.service.converter.MiddleEastResponseConverter;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by sima on 2/9/2015.
 */
public class MiddleEastSMSGatewayServiceImpl implements MiddleEastSMSGatewayService {

    private ServiceSoap_PortType service;
    private MiddleEastSMSGatewayUtils utils = new MiddleEastSMSGatewayUtils();
    final static Logger logger = Logger.getLogger(MiddleEastSMSGatewayServiceImpl.class);
    MiddleEastResponseConverter responseConverter = new MiddleEastResponseConverter();

    public MiddleEastSMSGatewayServiceImpl() {
        try {
            service = new ServiceLocator().getServiceSoap(new URL(utils.getSmsURL()));
        } catch (ServiceException | MalformedURLException e) {
            logger.error(new StringBuilder("There is a problem in fetching WSDL file").append(e.getMessage()));
        }
    }

    public SendSMSResDTO sendSMS(SensSMSReqDTO smsReqDTO) {
        SendSMSResDTO sendSMSResDTO = null;
        try {
            if (logger.isInfoEnabled())
                logger.info("Send SMS service is running ...");
            String response = service.sendSms(utils.getUsername(), utils.getPassword(), smsReqDTO.getSmsToken(),
                    smsReqDTO.getCellNumber(), "0", 1, 2, null, utils.getDomain(), utils.getNumber(), 0, 0, null, null);
            if (logger.isInfoEnabled())
                logger.info(new StringBuilder("SMS response is :").append(response));
            sendSMSResDTO = responseConverter.convertSendSMSResponseToResponseDTO(response);
        } catch (AxisFault e) {
            if (e.getCause() instanceof UnknownHostException) {
                logger.error(new StringBuilder("SMS host is not available:").append(e.getMessage()));
                sendSMSResDTO = responseConverter.getTimeoutSendSMSDTO();
            }
        } catch (Exception e) {
            logger.error(new StringBuilder("An unexpected exception occurred: ").append(e.getMessage()));
            sendSMSResDTO = responseConverter.getFailedSendSMSDTO();
        }
        return sendSMSResDTO;
    }
}
