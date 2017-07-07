package xyz.homapay.hampay.core.test.flows.security;

import org.junit.Test;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithms;
import xyz.homapay.hampay.core.server.security.SecurityAlgorithmsImpl;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sima on 10/10/15.
 * sima.ahmadvand@gmail.com
 */
public class SecurityAlgorithmTest {
    
    private SecurityAlgorithms securityAlgorithms = new SecurityAlgorithmsImpl();
    
    @Test
    public void testGeneratePassword() throws Exception{
        String password = securityAlgorithms.generatePassword("baghaliii","12345","e3c2a482ad45b601","fbed3f87-3ae3-46e1-bb83-a08bf8672ba2");
        assertEquals(password,"fc12c37c05367eaf90d6744233dd72519aa897bd97952763161e33b0f8d4424b");
    }
}
