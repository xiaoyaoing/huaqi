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

@RestController
@RequestMapping("/api/v1/fund")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list") //不用登陆
    public ResponseEntity<ResponseVO> getFundList(HttpSession session, @RequestHeader("uuid") String uuid) {
        if (session.getAttribute("getFundListApiUuid") != null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("getFundListApiUuid", uuid);
        session.setMaxInactiveInterval(30 * 60);//每30分钟可以调用一次
        return ResponseEntity.ok(projectService.getFundList());
    }

    @GetMapping("/{uuid}/detail")
    public ResponseEntity<ResponseVO> getDetail(HttpSession session, @PathVariable("uuid") String projectUuid, @RequestHeader("uuid") String apiUuid) {  //具体信息
        if (session.getAttribute("getDetailApiUuid") != null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("getDetailApiUuid", apiUuid);
        session.setMaxInactiveInterval(30 * 60);//每30分钟可以调用一次
        return ResponseEntity.ok(projectService.getDetail(projectUuid));
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
    public ResponseEntity<ResponseVO> create(HttpSession session, @RequestHeader("uuid") String uuid, @RequestHeader("Content-Type") String contentType, @RequestBody ProjectForm project) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        if (session.getAttribute("createApiUuid") != null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("createApiUuid", uuid);
        session.setMaxInactiveInterval(30 * 60);//每30分钟可以调用一次
        return ResponseEntity.ok(projectService.create(project));
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
