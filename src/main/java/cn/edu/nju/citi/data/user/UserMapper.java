package cn.edu.nju.citi.data.user;

import com.edu.nju.citi.PO.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //创建用户
    int createUser(User user);

    //用ID查找用户
    User getUserByID(Integer id);

    //用usename查找
    User getUserByName(String name);

    //通过Email查找
    User getUserByEmail(String email);

    //更新
    int updateUser(User user);
}
