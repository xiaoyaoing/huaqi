package com.edu.nju.citi;

import com.edu.nju.citi.PO.Fund;
import com.edu.nju.citi.data.user.FundMapper;
import com.edu.nju.citi.form.FundCreationForm;
import com.edu.nju.citi.form.FundTimeForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FundMapperTest {
    @Autowired
    FundMapper fundMapper;

    @Test
    public void testcreateFund(){
        FundCreationForm creationForm=new FundCreationForm();
        FundTimeForm fundTimeForm=new FundTimeForm();
        fundTimeForm.setBeginTime(new Date("2020/9/15"));
        fundTimeForm.setEndTime(new Date("2020/10/23"));
        creationForm.setName("原神");
        creationForm.setIndustry("游戏");
        creationForm.setFundGoal("策划sima");
        creationForm.setFundTimeRange(fundTimeForm);
        creationForm.setInvestigationResult("迟早药丸");
        creationForm.setDistributionDescription("12345");
        creationForm.setMinimumInvestAmount("648");
        creationForm.setRiskPotential("氪金没前途");
        //System.out.println(creationForm.toString());
        Fund fund=new Fund(1, creationForm);
        fund.setBeginTime("2020/9/15");
        fund.setEndTime("2020/10/25");
        fundMapper.createFund(fund);
    }
    @Test
    public void testUpdateFund(){
        FundCreationForm creationForm=new FundCreationForm();
        FundTimeForm fundTimeForm=new FundTimeForm();
        fundTimeForm.setBeginTime(new Date("2020/9/15"));
        fundTimeForm.setEndTime(new Date("2020/10/23"));
        creationForm.setName("原神");
        creationForm.setIndustry("游戏");
        creationForm.setFundGoal("策划sima");
        creationForm.setFundTimeRange(fundTimeForm);
        creationForm.setInvestigationResult("迟早药丸");
        creationForm.setDistributionDescription("12345");
        creationForm.setMinimumInvestAmount("648");
        creationForm.setRiskPotential("氪金没前途");
        //System.out.println(creationForm.toString());
        Fund fund=new Fund(1, creationForm);
        fund.setBeginTime("2020/9/15");
        fund.setEndTime("2020/10/29");
        fundMapper.updateFund(fund);
    }
    @Test
    public void getFund(){
        Fund fund=fundMapper.getFundById(1);
        System.out.println(fund.toString());
    }
}
