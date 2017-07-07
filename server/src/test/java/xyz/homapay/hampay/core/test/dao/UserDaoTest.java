package xyz.homapay.hampay.core.test.dao;

import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.testng.annotations.Test;
import xyz.homapay.hampay.core.server.dao.UserDao;
import xyz.homapay.hampay.core.server.dao.impl.UserDaoImpl;

/**
 * Created by sima on 10/12/15.
 * sima.ahmadvand@gmail.com
 */
public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
//    @Ignore
    public void testInsertImage() throws Exception {
        userDao.insertImage(IOUtils.toByteArray(this.getClass().getResourceAsStream("/uploadImageTestPic.png"))
                , new ObjectId("55f15b6444ae5c76a120b07b"));
    }
}
