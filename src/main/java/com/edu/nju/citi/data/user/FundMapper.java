package com.edu.nju.citi.data.user;

import com.edu.nju.citi.PO.Fund;
import com.edu.nju.citi.form.FundCreationForm;
import com.edu.nju.citi.form.FundTimeForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface FundMapper {
    Fund getFundById(Integer id);
    Fund getFundByName(String name);
    int updateFund(Fund fund);
    int createFund(Fund fund);
}
