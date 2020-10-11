package com.edu.nju.citi.data.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CitiUserMapper {
    int bindAccount(Integer id,String token,String fresh_token);
    int unbindAccount(Integer id);
}
