package cn.edu.nju.citi.vo;

import lombok.Data;

@Data
public class FundInfoVO {
    private String uuid;

    private String name;

    private String industry;

    private FundTimeVO fundTimeRange;

    private String riskPotential;

    private String investigationResult;

    private String distributionDescription;

    private String fundGoal;

    private String minimumInvestAmount;
}
