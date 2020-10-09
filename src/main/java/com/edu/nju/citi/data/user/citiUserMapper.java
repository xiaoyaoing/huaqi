package com.edu.nju.citi.data.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface citiUserMapper {
    int bindAccount();
    int unbindAccount();
}
