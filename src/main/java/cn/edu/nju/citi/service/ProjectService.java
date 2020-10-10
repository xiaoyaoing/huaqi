package cn.edu.nju.citi.service;


import cn.edu.nju.citi.vo.FundInvestmentVO;
import cn.edu.nju.citi.vo.FundReportVO;
import cn.edu.nju.citi.vo.ProjectVO;
import cn.edu.nju.citi.vo.ResponseVO;


public interface ProjectService {
    ResponseVO getFundList();

    ResponseVO getDetail(String uuid);

    ResponseVO getReport(String uuid);

    ResponseVO postReport(String uuid, FundReportVO fundReport);

    ResponseVO invest(String uuid, String sessionID, FundInvestmentVO fundInvestment);

    ResponseVO create(ProjectVO project);
}
