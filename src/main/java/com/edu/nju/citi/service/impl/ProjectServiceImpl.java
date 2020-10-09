package com.edu.nju.citi.service.impl;

import com.edu.nju.citi.VO.FundReportForm;
import com.edu.nju.citi.VO.ProjectForm;
import com.edu.nju.citi.VO.ResponseVO;
import com.edu.nju.citi.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ResponseVO<List<ProjectForm>> getFundList() {
        //从数据库获取项目实例并且封装成一个list
        //具体方式应该是从ProjectDao调用方法得到一个ProjectEntity的list
        //再通过这个list进行ProjectForm的list的初始化
        //最后返回用最后的list构造的ResponseVO
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
        //通过数据库更新每日报告
        return ResponseVO.ok();
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
