package com.edu.nju.citi.PO;

import com.edu.nju.citi.form.FundCreationForm;
import com.edu.nju.citi.form.FundTimeForm;
import lombok.Data;

import java.util.Date;

@Data
public class Fund {
    private Integer id;

    private String name;

    private String industry;

    private String riskPotential;

    private String investigationResult;

    private String distributionDescription;

    private String fundGoal;

    private String minimumInvestAmount;

    private String beginTime;

    private String endTime;
    public Fund(){

    }
    public Fund(int id,FundCreationForm creationForm){
        this.id=id;
        name=creationForm.getName();
        industry=creationForm.getIndustry();
        riskPotential=creationForm.getRiskPotential();
        investigationResult=creationForm.getInvestigationResult();
        distributionDescription=creationForm.getDistributionDescription();
        fundGoal=creationForm.getFundGoal();
        minimumInvestAmount=creationForm.getMinimumInvestAmount();
        beginTime=creationForm.getFundTimeRange().getBeginTime().toString();
        endTime=creationForm.getFundTimeRange().getEndTime().toString();
    }
}
