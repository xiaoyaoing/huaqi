package com.edu.nju.citi;

import com.edu.nju.citi.API.Account;
import com.edu.nju.citi.API.Authorize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTest {
    @Test
    public void testgetToken() {
        Account.getAccountInformation(Authorize.getToken(Authorize.getAccessToken()));
    }
}
