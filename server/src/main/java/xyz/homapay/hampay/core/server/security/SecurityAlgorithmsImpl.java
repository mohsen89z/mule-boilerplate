package xyz.homapay.hampay.core.server.security;

import xyz.homapay.hampay.core.common.data.model.User;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

/**
 * Created by kamyar on 15/1/6 AD.
 */
public class SecurityAlgorithmsImpl implements SecurityAlgorithms {

    public String createSMSCode(String imei, String cellNo) {
        Random random = new Random(imei.hashCode() ^ cellNo.hashCode() ^ new Date().hashCode());
        return Integer.toString(random.nextInt(89999) + 10000);
    }

    public String generateRandomId() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public Integer generateDepositAmount(Integer min, Integer max) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(max - min) + min;
    }

    public String generatePassword(String memorableKey, String passcode, String deviceId, String installationToken) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((deviceId + toHexString(memorableKey) +
                    String.valueOf(installationToken.length() * 3 + 11)
                    + passcode
                    + installationToken
                    + String.valueOf(memorableKey.length() * 17 + 23)).getBytes("UTF-8"));
            return String.format("%0" + (hash.length * 2) + 'x', new BigInteger(1, hash));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ignored) {
        }
        return null;
    }


    public String generatePassword(String memorableKey, String passcode, User user) {
        return generatePassword(memorableKey,passcode,user.getFirstActiveDevice().getDeviceId(),
                user.getFirstActiveDevice().getInstallationToken());
    }

    /**
     * convert into Hexadecimal notation of Unicode.<br>
     * example)a?\u0061
     *
     * @param str
     * @return
     */
    private String toHexString(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append(toHexString(str.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * convert into Hexadecimal notation of Unicode.<br>
     * example)a?\u0061
     *
     * @param ch
     * @return
     */
    private String toHexString(char ch) {
        String hex = Integer.toHexString((int) ch);
        while (hex.length() < 4) {
            hex = "0" + hex;
        }
        return hex;
    }

}
