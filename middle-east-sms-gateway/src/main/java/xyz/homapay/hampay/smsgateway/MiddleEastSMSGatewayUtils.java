package xyz.homapay.hampay.smsgateway;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sima on 1/29/2015.
 */
public class MiddleEastSMSGatewayUtils {

    private Properties configProperty;
    private static final Logger logger = Logger.getLogger(MiddleEastSMSGatewayUtils.class);

    public MiddleEastSMSGatewayUtils() {
        try {
            populateConfigProperty();
        } catch (IOException e) {
            logger.error(" config file could not be loaded");
            throw new RuntimeException();
        }
    }

    private void populateConfigProperty() throws IOException {
        configProperty = new Properties();
        configProperty.load((this.getClass().getResourceAsStream("/sms_me.properties")));
    }

    public String getSmsURL() {
        return configProperty.getProperty("sms.url");
    }

    public String getUsername() {
        return configProperty.getProperty("sms.username");
    }

    public String getPassword() {
        return configProperty.getProperty("sms.password");
    }

    public String getNumber() {
        return configProperty.getProperty("sms.number");
    }

    public String getDomain() {
        return configProperty.getProperty("sms.domain");
    }

}
