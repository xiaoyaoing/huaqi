package cn.edu.nju.citi.service;


import cn.edu.nju.citi.form.FundCreationForm;
import cn.edu.nju.citi.form.FundInvestmentForm;
import cn.edu.nju.citi.form.FundReportForm;
import cn.edu.nju.citi.vo.ResponseVO;


public interface ProjectService {
    ResponseVO getFundList();

    ResponseVO getDetail(String uuid);

    ResponseVO getReport(String uuid);

    ResponseVO postReport(String uuid, FundReportForm fundReport);

    ResponseVO invest(String uuid, String sessionID, FundInvestmentForm fundInvestment);

    ResponseVO create(FundCreationForm project);
}
