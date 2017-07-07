package xyz.homapay.hampay.core.test.flows.misc;

import org.junit.Test;
import org.mule.api.MuleEvent;
import xyz.homapay.hampay.core.common.data.dto.IdpUserDTO;
import xyz.homapay.hampay.core.test.AbstractTestSuite;

/**
 * Created by sima on 7/20/15.
 */
public class IDPTest extends AbstractTestSuite {

    @Test
    public void idpCreateUser() throws Exception {
        IdpUserDTO idpUserDTO = new IdpUserDTO();
        idpUserDTO.setUsername("0083519076");
        idpUserDTO.setUserPassword("41cec80d8dd4d08c007400650073007411912345a533ee41-5f29-4ab7-94d4-f425289c094391");

        MuleEvent result = runFlow("LoginToIdentityProvider", testEvent(""));
//        MuleEvent result1 = runFlow("LoginUserToIdentityProvider", testEvent(new Gson().toJson(idpUserDTO, IdpUserDTO.class)));

    }

    @Test
    public void idpTestUserLogin() throws Exception {
        MuleEvent event = runFlow("LoginToIdentityProvider", testEvent(""));
        System.out.println(event.getMessage().getPayload());
    }

}
