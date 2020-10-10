package cn.edu.nju.citi.vo;

import lombok.Data;

import java.util.Date;

@Data
public class FundReportVO {
    private Date time;

    private String income;

    private String investmentDetail;

    private String investmentStrategy;

    private String analyseResult;
}
