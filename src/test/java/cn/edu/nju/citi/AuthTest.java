package cn.edu.nju.citi;


import cn.edu.nju.citi.API.Account;
import cn.edu.nju.citi.API.Authorize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTest {
    @Test
    public void testgetToken() {
        Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
