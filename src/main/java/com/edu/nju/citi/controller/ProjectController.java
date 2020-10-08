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

//要不要考虑一下全部用HttpServletRequest来交互？
@RestController
@RequestMapping("/api/v1/fund")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    //这里的uuid是什么的uuid？
    //这里的uuid是请求的uuid，用于标识请求，应该是从header里边提取
    @GetMapping("/list") //不用登陆
    public ResponseVO getFundList(@RequestHeader("uuid") String uuid) {
        return projectService.getFundList();
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
        return new ResponseEntity<>(projectService.create(uuid, project), HttpStatus.OK);
    }

    @PostMapping("/{uuid}/report")
    public ResponseEntity<ResponseVO> postFundReport(HttpSession session, @PathVariable("uuid") String projectUuid, @RequestHeader("uuid") String apiUuid, @RequestHeader("Content-Type") String contentType, @RequestBody FundReportForm fundReport) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        if (session.getAttribute("postFundReportApiUuid") != null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("postFundReportApiUuid", apiUuid);
        return ResponseEntity.ok(projectService.postReport(projectUuid, fundReport));
    }
}
