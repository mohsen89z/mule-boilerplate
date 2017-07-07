package xyz.homapay.hampay.core.test;

import org.bson.types.ObjectId;
import org.testng.annotations.Test;
import xyz.homapay.hampay.common.core.model.dto.UserVerificationStatus;
import xyz.homapay.hampay.core.common.data.model.*;
import xyz.homapay.hampay.core.server.helper.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sima on 8/18/15.
 */
public class TestUtil {

    public static User createUser1() {
        User user = new User();
        user.setId(new ObjectId(new Date()));
        user.setCustomer(new IndividualCustomer());
        user.getCustomer().setContacts(new HashMap<String, Contact>(2));
        Contact contact1 = new Contact();
        contact1.setCellNumber("09129479928");
        contact1.setDisplayName("هومن امینی");
        user.getCustomer().getContacts().put("09129479928", contact1);
        Contact contact2 = new Contact();
        contact2.setCellNumber("09126157905");
        contact2.setDisplayName("امیر شرف کار");
        user.getCustomer().getContacts().put("09126157905", contact2);
        user.getCustomer().setName("سیما احمدوند");
        user.getCustomer().setFirstName("سیما");
        user.getCustomer().setLastName("احمدوند");
        user.getCustomer().setFullEnglishName("Sima Ahmadvand");
        user.getCustomer().setBirthDate(new Date());
        user.getCustomer().setBirthPlace("Tehran");
        user.getCustomer().setFatherName("محسن");
        user.getCustomer().setDefaultAccount(new Account());
        user.getCustomer().getDefaultAccount().setCustomer(user.getCustomer());
        user.getCustomer().getDefaultAccount().setAccountNumber("55555/22/566966");
        user.getCustomer().getDefaultAccount().setBank(new Bank());
        user.getCustomer().getDefaultAccount().getBank().setAccountFormat("######/##/#######");
        user.getCustomer().getDefaultAccount().getBank().setCode("18");
        user.getCustomer().getDefaultAccount().getBank().setName("بانک تجارت");
        user.getCustomer().setAccounts(new ArrayList<Account>());
        user.getCustomer().getAccounts().add(user.getCustomer().getDefaultAccount());
        user.getCustomer().setPhoneNumber("09125252282");
        user.getCustomer().setIdentityCode("0083519076");
        user.setRegistrationStep(User.RegistrationStep.USER_ACTIVATED);
        user.setIsActive(true);
        user.setActivationDate(new Date());
        user.setTacAcceptDate(new Date());
        user.setBindingStatus(User.BindingStatus.LINK);
        user.setDevices(new ArrayList<UserDevice>());
        UserDevice userDevice = new UserDevice();
        userDevice.setActivationDate(new Date());
        userDevice.setIsActive(true);
        userDevice.setInstallationToken("9873928742");
        userDevice.setUser(user);
        user.getDevices().add(userDevice);
        user.setLastLoginDate(new Date());
        user.setMobileNo("09125252282");
        user.setRecentLoginDate(new Date());
        user.setRegistrationExpiryDate(new Date());
        user.setSmsToken("76786");
        user.setUserId("0083519076");
        user.setUserIdToken("8743659823498723987442");
        user.setVerificationStatus(UserVerificationStatus.DELEGATED);
        return user;
    }

    public static User createUser2() {
        User user = new User();
        user.setCustomer(new IndividualCustomer());
        user.getCustomer().setContacts(new HashMap<String, Contact>(2));
        Contact contact1 = new Contact();
        contact1.setCellNumber("09129479928");
        contact1.setDisplayName("هومن امینی");
        user.getCustomer().getContacts().put("09129479928", contact1);
        Contact contact2 = new Contact();
        contact2.setCellNumber("09126157905");
        contact2.setDisplayName("امیر شرف کار");
        user.getCustomer().getContacts().put("09126157905", contact2);
        user.getCustomer().setName("سیما احمدوند");
        user.getCustomer().setFirstName("سیما");
        user.getCustomer().setLastName("احمدوند");
        user.getCustomer().setFullEnglishName("Sima Ahmadvand");
        user.getCustomer().setBirthDate(new Date());
        user.getCustomer().setBirthPlace("Tehran");
        user.getCustomer().setFatherName("محسن");
        user.getCustomer().setDefaultAccount(new Account());
        user.getCustomer().getDefaultAccount().setCustomer(user.getCustomer());
        user.getCustomer().getDefaultAccount().setAccountNumber("340411524");
        user.getCustomer().getDefaultAccount().setBank(new Bank());
        user.getCustomer().getDefaultAccount().getBank().setAccountFormat("##########");
        user.getCustomer().getDefaultAccount().getBank().setCode("78");
        user.getCustomer().getDefaultAccount().getBank().setName("بانک خاورمیانه");
        user.getCustomer().setAccounts(new ArrayList<Account>());
        user.getCustomer().getAccounts().add(user.getCustomer().getDefaultAccount());
        user.getCustomer().setPhoneNumber("09125252282");
        user.getCustomer().setIdentityCode("0083519076");
        user.setRegistrationStep(User.RegistrationStep.USER_ACTIVATED);
        user.setIsActive(true);
        user.setActivationDate(new Date());
        user.setTacAcceptDate(new Date());
        user.setBindingStatus(User.BindingStatus.LINK);
        user.setDevices(new ArrayList<UserDevice>());
        UserDevice userDevice = new UserDevice();
        userDevice.setActivationDate(new Date());
        userDevice.setIsActive(true);
        userDevice.setInstallationToken("9873928742");
        userDevice.setUser(user);
        user.getDevices().add(userDevice);
        user.setLastLoginDate(new Date());
        user.setMobileNo("09125252282");
        user.setRecentLoginDate(new Date());
        user.setRegistrationExpiryDate(new Date());
        user.setSmsToken("76786");
        user.setUserId("0083519076");
        user.setUserIdToken("8743659823498723987442");
        user.setVerificationStatus(UserVerificationStatus.DELEGATED);
        return user;
    }

    public static Business createBusiness() {
        Business business = new Business();
        business.setIdentityCode("1099");
        business.setPhoneNumber("09126587456");
        business.setDefaultAccount(new Account());
        business.getDefaultAccount().setCustomer(business);
        business.getDefaultAccount().setAccountNumber("206876343");
        business.getDefaultAccount().setBank(new Bank());
        business.getDefaultAccount().getBank().setAccountFormat("###########");
        business.getDefaultAccount().getBank().setCode("78");
        business.getDefaultAccount().getBank().setName("بانک خاورمیانه");
        business.setName("test organization");
        return business;
    }

    @Test
    public void testValidateEmailFormat() throws Exception {
        assertEquals(Util.validateEmailFormat("1@test.com"), true);
        assertEquals(Util.validateEmailFormat("sima.ahmadvand@test.com"), true);
        assertEquals(Util.validateEmailFormat("simaahmadvand@test"), false);
        assertEquals(Util.validateEmailFormat("simaahmadvand.com"), false);
    }
}
