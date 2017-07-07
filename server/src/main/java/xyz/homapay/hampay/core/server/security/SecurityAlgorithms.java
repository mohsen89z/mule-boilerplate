package xyz.homapay.hampay.core.server.security;


import xyz.homapay.hampay.core.common.data.model.User;

/**
 * Created by kamyar on 15/1/6 AD.
 */
public interface SecurityAlgorithms {
    String createSMSCode(String imei, String cellNo);

    String generateRandomId();

    Integer generateDepositAmount(Integer min, Integer max);

    String generatePassword(String passcode, String memorableKey, String deviceId, String installationToken);

    String generatePassword(String memorableKey, String passcode, User user);
}
