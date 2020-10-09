package com.edu.nju.citi.data.user;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userMapper {
    int createUser();
    int getUserByID();
    int getUserByName();
    int getUserByEmail();
    int updateUser();
}
