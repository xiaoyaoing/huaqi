package cn.edu.nju.citi;

import cn.edu.nju.citi.API.Authorize;
import cn.edu.nju.citi.data.user.CitiUserMapper;
import cn.edu.nju.citi.data.user.UserMapper;
import cn.edu.nju.citi.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CitiUserTest {
    @Autowired
    CitiUserMapper citiUserMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void testBindAccount() {
        String returnInformation = Authorize.getAccessToken();
        String token = Authorize.getToken(returnInformation);
        String fresh_token = Authorize.getRefresh_Token(returnInformation);
        System.out.println(token);
        User user = userMapper.getUserByName("TscRubbish");
        System.out.println(user.getId());
        citiUserMapper.bindAccount(user.getId(), token, fresh_token);
    }

    @Test
    void testunBindAccount() {
        User user = userMapper.getUserByName("TscRubbish");
        System.out.println(user.getId());
        citiUserMapper.unbindAccount(user.getId());
    }
}
