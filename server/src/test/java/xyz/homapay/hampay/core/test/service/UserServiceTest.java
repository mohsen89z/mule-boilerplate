package xyz.homapay.hampay.core.test.service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import xyz.homapay.hampay.core.common.data.dto.DepositAmountDTO;
import xyz.homapay.hampay.core.common.data.model.User;
import xyz.homapay.hampay.core.server.dao.UserDao;
import xyz.homapay.hampay.core.server.service.UserService;
import xyz.homapay.hampay.core.test.TestUtil;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Created by sima on 8/18/15.
 */
public class UserServiceTest {
    private UserService userService = new UserService();
    private UserDao userDaoMock;


    @Before
    public void init() throws Exception {
        userDaoMock = createMock(UserDao.class);
        userService.setUserDao(userDaoMock);
    }

    @Test
    public void testCreateDepositDTO() throws Exception {
        User user = TestUtil.createUser1();
        DepositAmountDTO depositAmountDTO = userService.createDepositDTO(user);
        assertNotNull(depositAmountDTO.getAmount());
        assertTrue(depositAmountDTO.getHampayAccount().
                equals("0098070001") || depositAmountDTO.getHampayAccount().equals("1005/11/040/707071204"));
        assertEquals(depositAmountDTO.getUserAccount(), user.getCustomer().getDefaultAccount().getAccountNumber());
    }

    @Test
    public void testUpdateUserEmailSuccess() throws Exception {
        reset(userDaoMock);
        userDaoMock.updateUserEmail(isA(String.class), isA(ObjectId.class));
        replay(userDaoMock);
        userService.updateUserEmail("sima@homapay.xyz", TestUtil.createUser1());
        verify(userDaoMock);
    }

    @Test(expected = InvalidFormatException.class)
    public void testUpdateUserEmailInvalidFormatException1() throws Exception {
        userService.updateUserEmail("simahomapay.xyz", TestUtil.createUser1());
    }

    @Test(expected = InvalidFormatException.class)
    public void testUpdateUserEmailInvalidFormatException2() throws Exception {
        userService.updateUserEmail(null, TestUtil.createUser1());
    }

}
