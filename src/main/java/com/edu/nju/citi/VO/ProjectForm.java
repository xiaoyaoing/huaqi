package com.edu.nju.citi.VO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectForm {

    private String name;

    private String industry;

    private List<Date> fundTimeRange;

    private String riskPotential;

    private String investigationResult;

    private String distributionDescription;

    private String fundGoal;

    private String minimumInvestAmount;

}
