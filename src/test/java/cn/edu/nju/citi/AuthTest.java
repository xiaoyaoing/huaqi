package cn.edu.nju.citi;

<<<<<<< HEAD:src/test/java/cn/edu/nju/citi/AuthTest.java
import cn.edu.nju.citi.API.Account;
import cn.edu.nju.citi.API.Authorize;
=======
import com.edu.nju.citi.API.Account;
import com.edu.nju.citi.API.Authorize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
>>>>>>> tsc:src/test/java/com/edu/nju/citi/AuthTest.java

@SpringBootTest
public class AuthTest {
    @Test
    public void testgetToken() {
        Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
