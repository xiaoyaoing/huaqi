package cn.edu.nju.citi.vo;

import lombok.Data;

import java.util.List;

@Data
public class FundReportListVO {
    private List<FundReportVO> reports;

    private List<MarketDataVO> marketData;
}
