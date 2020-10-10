package cn.edu.nju.citi.service.impl;

import cn.edu.nju.citi.service.ProjectService;
import cn.edu.nju.citi.vo.FundInvestmentVO;
import cn.edu.nju.citi.vo.FundReportVO;
import cn.edu.nju.citi.vo.ProjectVO;
import cn.edu.nju.citi.vo.ResponseVO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ResponseVO getFundList() {
        //从数据库获取项目实例并且封装成一个list
        //具体方式应该是从ProjectDao调用方法得到一个ProjectEntity的list
        //再通过这个list进行ProjectForm的list的初始化
        //最后返回用最后的list构造的ResponseVO
        return null;
    }

    @Override
    public ResponseVO getDetail(String uuid) {
        //通过uuid查找项目，得到ProjectEntity
        //并且通过ProjectEntity来初始化ProjectForm
        //返回的是一个Project和ProjectForm的list构造的ResponseVO
        return null;
    }

    @Override
    public ResponseVO getReport(String uuid) {
        //从数据库中获取
        //list套list
        return null;
    }

    @Override
    public ResponseVO postReport(String uuid, FundReportVO fundReport) {
        //通过数据库更新每日报告
        return ResponseVO.ok();
    }

    @Override
    public ResponseVO invest(String uuid, String sessionID, FundInvestmentVO fundInvestment) {
        //调用UserService的对应方法
        return null;
    }

    @Override
    public ResponseVO create(ProjectVO project) {
        //生成唯一的项目uuid
        String projectUuid = UUID.randomUUID().toString();
        //创建项目，在数据库中进行关联

        //将uuid作为构造参数构造ResponseVO
        //返回构造的ResponseVO
        return ResponseVO.ok(projectUuid);
    }
}
