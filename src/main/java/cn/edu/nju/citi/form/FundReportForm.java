package cn.edu.nju.citi.form;

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