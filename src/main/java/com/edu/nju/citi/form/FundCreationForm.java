package com.edu.nju.citi.form;

import lombok.Data;

@Data
public class FundCreationForm {
    private String name;

    private String industry;

    private FundTimeForm fundTimeRange;

    private String riskPotential;

    private String investigationResult;

    private String distributionDescription;

    private String fundGoal;

    private String minimumInvestAmount;
}
