package cn.edu.nju.citi;

import cn.edu.nju.citi.data.user.UserMapper;
import cn.edu.nju.citi.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class createUserTest {
    @Autowired
    UserMapper usermapper;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("2010075010@qq.com");
        user.setId(1);
        user.setUsername("TscRubbish");
        user.setPassword("123456");
        try {
            usermapper.createUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testUpdateUser() {
        User user;
        user = usermapper.getUserByID((Integer) 1);
        user.setPassword("654321");
        User user2 = usermapper.getUserByName("TscRubbish");
        try {
            usermapper.updateUser(user);
            user2.setEmail("191250129@smail.nju.edu.cn");
            usermapper.updateUser(user2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        User user3 = usermapper.getUserByName("123");
        if (user3 == null) System.out.println("123 not founding");
    }
}
