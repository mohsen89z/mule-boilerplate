package xyz.homapay.hampay.core.server.helper;

import org.apache.log4j.Logger;
import xyz.homapay.hampay.common.switchbay.model.SwitchResponseStatus;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by sima on 6/29/15.
 */
public class PropertiesUtil {

    private Properties accountProperties, contactsProperties, bankProperties, serverProperties,
            configProperties, notificationProperties, smsBlackListProperties, switchProperties;
    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    public PropertiesUtil() {
        try {
            populateProperties();
        } catch (IOException e) {
            logger.error(" config file could not be loaded");
            throw new RuntimeException();
        }
    }

    private void populateProperties() throws IOException {
        accountProperties = new Properties();
        contactsProperties = new Properties();
        bankProperties = new Properties();
        serverProperties = new Properties();
        configProperties = new Properties();
        smsBlackListProperties = new Properties();
        notificationProperties = new Properties();
        switchProperties = new Properties();
        accountProperties.load(this.getClass().getResourceAsStream("/account.properties"));
        contactsProperties.load(this.getClass().getResourceAsStream("/contacts.properties"));
        bankProperties.load(this.getClass().getResourceAsStream("/bank.properties"));
        serverProperties.load(this.getClass().getResourceAsStream("/server.properties"));
        configProperties.load(this.getClass().getResourceAsStream("/config.properties"));
        smsBlackListProperties.load(this.getClass().getResourceAsStream("/sms-black-list.properties"));
        notificationProperties.load(this.getClass().getResourceAsStream("/notification.properties"));
        switchProperties.load(this.getClass().getResourceAsStream("/hampay-switch.properties"));
    }

    public Integer getMinimumDepositAmount() {
        return Integer.parseInt(accountProperties.getProperty("account.min"));
    }

    public Integer getMaximumDepositAmount() {
        return Integer.parseInt(accountProperties.getProperty("account.max"));
    }

    public String getTejaratAccount() {
        return accountProperties.getProperty("account.tejarat");
    }

    public String getMiddleEastAccount() {
        return accountProperties.getProperty("account.middle.east");
    }

    public String createVerifyComment(DepositAmountDTO depositDTO) {
        return MessageFormat.format(accountProperties.getProperty("account.comment"),
                depositDTO.getAmount().toString(), depositDTO.getHampayAccount(), depositDTO.getUserAccount(),
                depositDTO.getAmount().toString(), depositDTO.getUserAccount(), depositDTO.getHampayAccount());

    }

    public String getTejaratHampayYarNumber() {
        return contactsProperties.getProperty("tejarat.hampay.yar.number");
    }

    public String getMiddleEastHampayYarNumber() {
        return contactsProperties.getProperty("middle.east.hampay.yar.number");
    }

    public String getTejaratBankCode() {
        return bankProperties.getProperty("tejarat.bank.code");
    }

    public String getMiddleEastBankCode() {
        return bankProperties.getProperty("middle.east.bank.code");
    }

    public String getTejaratHampayYarDisplayName() {
        return contactsProperties.getProperty("tejarat.hampay.yar.display.name");
    }

    public String getMiddleEastHampayYarDisplayName() {
        return contactsProperties.getProperty("middle.east.hampay.yar.display.name");
    }

    public ArrayList<String> getMemWordRestrictedValuesAsListString() {
        ArrayList<String> arr = new ArrayList<>();
        String key = "security.memorable-code.restricted-characters";
        if (serverProperties.containsKey(key)) {
            String value = serverProperties.getProperty(key);
            String[] strArr = value.split(",");
            for (String val : strArr)
                arr.add(val.trim());
        }
        return arr;
    }

    public char[] getMemWordRestrictedValuesAsArrCharArray() {
        String key = "security.memorable-code.restricted-characters";
        char[] ret = null;
        if (serverProperties.containsKey(key)) {
            ArrayList<Character> arr = new ArrayList<>();
            String value = serverProperties.getProperty(key);
            String[] strArr = value.split(",");
            for (String val : strArr) {
                try {
                    arr.add(val.trim().charAt(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ret = new char[arr.size()];
            for (int i = 0; i < arr.size(); ++i)
                ret[i] = arr.get(i);

        }
        return ret;
    }

    public Long getMinimumUserTransferAmount() {
        return Long.parseLong(configProperties.getProperty("user.min.transfer.amount"));
    }

    public Long getMaximumUserTransferAmount() {
        return Long.parseLong(configProperties.getProperty("user.max.transfer.amount"));
    }

    public String getNotVerifiedMessage() {
        return accountProperties.getProperty("account.not.verified.xfer.money.comment");
    }

    public List<String> getSMSBlackListNumbers() {
        return Arrays.asList(smsBlackListProperties.getProperty("black.list.numbers").split(","));
    }

    public String getSuccessfulPaymentNotificationMessage(Long amount) {
        return MessageFormat.format(notificationProperties.getProperty("payment.notification.success.msg"), amount.toString());
    }

    public String getInsufficientAmountPaymentNotificationMessage(String name) {
        return MessageFormat.format(notificationProperties.getProperty("payment.notification.insufficient.amount.msg"), name);
    }

    public String getJointNotificationMessage() {
        return notificationProperties.getProperty("joint.notification.msg");
    }

    public String getRejectStatusMessage(SwitchResponseStatus rejectStatus) {
        String rejectMessage = switchProperties.getProperty(rejectStatus.toString());
        if (rejectMessage == null)
            rejectMessage = switchProperties.getProperty("GENERAL");
        return rejectMessage;
    }

    public String getUnsuccessfulPaymentName() {
        return notificationProperties.getProperty("unsuccessful.payment.notification.name");
    }

    public String getAppUpdateNotificationName() {
        return notificationProperties.getProperty("app.update.notification.name");
    }

    public String getAppUpdateNotificationMessage(String versionName) {
        return MessageFormat.format(notificationProperties.getProperty("app.update.notification.msg"), versionName);
    }

    public int getMaxUserImageSize() {
        return Integer.parseInt(configProperties.getProperty("max.image.size.kilobytes"));
    }

}
