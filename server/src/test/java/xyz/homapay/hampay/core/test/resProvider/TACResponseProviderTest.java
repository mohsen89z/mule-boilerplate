package xyz.homapay.hampay.core.test.resProvider;

import org.junit.Test;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.response.TACResponseProvider;
import xyz.homapay.hampay.core.server.service.UserService;

/**
 * Created by sima on 8/15/15.
 */
public class TACResponseProviderTest {

    private TACResponseProvider responseProvider = new TACResponseProvider();
    private UserService userService = new UserService();

    @Test
    public void createAlreadyAcceptedTACResponse() throws Exception {
        User user = userService.findActivatedUserByUserId("0061357480");
        responseProvider.createAlreadyAcceptedTACResponse("123456", user);
    }
}
