package cn.edu.nju.citi.service;


import cn.edu.nju.citi.form.FundReportForm;
import cn.edu.nju.citi.form.ProjectForm;
import cn.edu.nju.citi.vo.ResponseVO;


public interface ProjectService {
    ResponseVO getFundList();

    ResponseVO getDetail(String uuid);

    ResponseVO getReport(String uuid);

    ResponseVO postReport(String uuid, FundReportForm fundReport);

    ResponseVO invest(String uuid, String sessionID, String contentType);

    ResponseVO create(ProjectForm project);
}
