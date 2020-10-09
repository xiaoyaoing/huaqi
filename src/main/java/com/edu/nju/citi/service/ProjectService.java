package com.edu.nju.citi.service;


import com.edu.nju.citi.VO.FundReportForm;
import com.edu.nju.citi.VO.ProjectForm;
import com.edu.nju.citi.VO.ResponseVO;

import java.util.List;


public interface ProjectService {
    ResponseVO<List<ProjectForm>> getFundList();

    ResponseVO getDetail(String uuid);

    ResponseVO getReport(String uuid);

    ResponseVO postReport(String uuid, FundReportForm fundReport);

    ResponseVO invest(String uuid, String sessionID, String contentType);

    ResponseVO<String> create(String uuid, ProjectForm project);
}
