package com.edu.nju.citi.VO;

import lombok.Data;

import java.util.Date;

@Data
public class FundReportForm {
    private Date time;

    private String income;

    private String investmentDetail;

    private String investmentStrategy;

    private String analyseResult;
}
