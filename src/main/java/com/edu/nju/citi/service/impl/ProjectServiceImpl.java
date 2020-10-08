package com.edu.nju.citi.service.impl;

import com.edu.nju.citi.VO.FundReportForm;
import com.edu.nju.citi.VO.ProjectForm;
import com.edu.nju.citi.VO.ResponseVO;
import com.edu.nju.citi.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ResponseVO getFundList() {
        return null;
    }

    @Override
    public ResponseVO getDetail(String uuid) {
        return null;
    }

    @Override
    public ResponseVO getReport(String uuid) {
        return null;
    }

    @Override
    public ResponseVO postReport(String uuid, FundReportForm fundReport) {

        return null;
    }

    @Override
    public ResponseVO invest(String uuid, String sessionID, String contentType) {
        return null;
    }

    @Override
    public ResponseVO<String> create(String uuid, ProjectForm project) {
        //生成唯一的项目uuid
        String projectUuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //创建项目，在数据库中进行关联

        //将uuid作为构造参数构造ResponseVO
        //返回构造的ResponseVO
        return ResponseVO.ok(projectUuid);
    }


}
