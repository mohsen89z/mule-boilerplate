package xyz.homapay.hampay.core.server.helper;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.text.StrBuilder;
import xyz.homapay.hampay.common.core.model.dto.ContactDTO;
import xyz.homapay.hampay.core.common.data.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sima on 7/2/15.
 */
public class Util {

    public static int getRandomNumberInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static Date addDayToDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static String createTransactionReferenceCode() {
        StrBuilder strBuilder = new StrBuilder("HP-");
        Calendar calendar = Calendar.getInstance();
        strBuilder.append(RandomStringUtils.randomNumeric(4))
                .append(String.format("%02d", calendar.get(Calendar.MINUTE)))
                .append(String.format("%02d", calendar.get(Calendar.HOUR)));
        return strBuilder.toString();
    }


    public static Set<String> getIranMobileNumbersOnly(List<ContactDTO> contacts) {
        Set<String> numbers = new HashSet<>(contacts.size());
        for (ContactDTO contact : contacts) {
            String cellNumber = contact.getCellNumber().replaceAll(" ", "").replaceAll("-", "");
            if (cellNumber.startsWith("09") && cellNumber.length() == 11)
                numbers.add(cellNumber);
            else if (cellNumber.startsWith("+98") && cellNumber.length() == 13)
                numbers.add(cellNumber.replace("+98", "0"));
            else if (cellNumber.startsWith("0098") && cellNumber.length() == 14)
                numbers.add(cellNumber.replace("0098", "0"));
        }
        return numbers;
    }

    public static List<User.RegistrationStep> getFirstSectionRegistrationSteps() {
        List<User.RegistrationStep> registrationSteps = new ArrayList<>(3);
        registrationSteps.add(User.RegistrationStep.ENTRY_PASSED);
        registrationSteps.add(User.RegistrationStep.SMS_TOKEN_SENT);
        registrationSteps.add(User.RegistrationStep.SMS_TOKEN_VERIFIED);
        return registrationSteps;
    }

    public static List<User.RegistrationStep> getSecondSectionRegistrationSteps() {
        List<User.RegistrationStep> registrationSteps = new ArrayList<>(3);
        registrationSteps.add(User.RegistrationStep.SMS_TOKEN_VERIFIED);
        registrationSteps.add(User.RegistrationStep.USER_DATA_FETCHED);
        registrationSteps.add(User.RegistrationStep.USER_DATA_CONFIRMED);
        return registrationSteps;
    }

    public static List<User.RegistrationStep> getThirdSectionRegistrationSteps() {
        List<User.RegistrationStep> registrationSteps = new ArrayList<>(3);
        registrationSteps.add(User.RegistrationStep.USER_DATA_CONFIRMED);
        registrationSteps.add(User.RegistrationStep.DEPOSIT_AMOUNT_GENERATED);
        registrationSteps.add(User.RegistrationStep.ACCOUNT_XFER_VERIFIED);
        return registrationSteps;
    }

    public static List<User.RegistrationStep> getFourthSectionRegistrationSteps() {
        List<User.RegistrationStep> registrationSteps = new ArrayList<>(3);
        registrationSteps.add(User.RegistrationStep.USER_DATA_CONFIRMED);
        registrationSteps.add(User.RegistrationStep.ACCOUNT_XFER_VERIFIED);
        return registrationSteps;
    }

    public static boolean validateEmailFormat(String email) {
        Pattern pattern = Pattern.compile("^[-!#$%&'*+/0-9=?A-Z^_a-z{|}~](\\.?[-!#$%&'*+/0-9=?A-Z^_a-z{|}~])*@[a-zA-Z](-?[a-zA-Z0-9])*(\\.[a-zA-Z](-?[a-zA-Z0-9])*)+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String getFileContentAsString(InputStream inputStream) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();
    }

}
