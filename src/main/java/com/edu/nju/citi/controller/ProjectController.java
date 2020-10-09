package com.edu.nju.citi.controller;


import com.edu.nju.citi.VO.FundReportForm;
import com.edu.nju.citi.VO.ProjectForm;
import com.edu.nju.citi.VO.ResponseVO;
import com.edu.nju.citi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//要不要考虑一下全部用HttpServletRequest来交互？
@RestController
@RequestMapping("/api/v1/fund")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    //这里的uuid是什么的uuid？
    //这里的uuid是请求的uuid，用于标识请求，应该是从header里边提取
    @GetMapping("/list") //不用登陆
    public ResponseEntity<ResponseVO<List<ProjectForm>>> getFundList(HttpSession session, @RequestHeader("uuid") String uuid) {
        if (session.getAttribute("getFundListApiUuid") != null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("getFundListApiUuid", uuid);
        session.setMaxInactiveInterval(30 * 60);//每30分钟调用一次
        return ResponseEntity.ok(projectService.getFundList());
    }

    //uuid是在url中还是在http请求头中？
    //如果是header就用@RequestHeader
    //如果是url就用@RequestParam
    //在url里
    @GetMapping("/{uuid}/detail")
    public ResponseVO getDetail(@PathVariable("uuid") String uuid) {  //具体信息
        return projectService.getDetail(uuid);
    }

    //uuid同上
    @PostMapping("/{uuid}/invest")
    public ResponseVO invest(@PathVariable("uuid") String uuid, @CookieValue("session_id") String sessionID, @RequestHeader("Content-Type") String contentType, HttpSession session) {
        return projectService.invest(uuid, sessionID, contentType);
    }

    @GetMapping("/{uuid}/report")
    public ResponseVO getFundReport(@PathVariable("uuid") String uuid) {
        return projectService.getReport(uuid);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseVO<String>> create(@RequestHeader("uuid") String uuid, @RequestHeader("Content-Type") String contentType, @RequestBody ProjectForm project) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        return ResponseEntity.ok(projectService.create(uuid, project));
    }

    //公布已投资项目的细节
    @PostMapping("/{uuid}/report")
    public ResponseEntity<ResponseVO> postFundReport(HttpSession session, @PathVariable("uuid") String projectUuid, @RequestHeader("uuid") String apiUuid, @RequestHeader("Content-Type") String contentType, @RequestBody FundReportForm fundReport) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        if (session.getAttribute("postFundReportApiUuid") != null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("postFundReportApiUuid", apiUuid);
        session.setMaxInactiveInterval(24 * 60 * 60);//一天只能调用一次
        return ResponseEntity.ok(projectService.postReport(projectUuid, fundReport));
    }
}
