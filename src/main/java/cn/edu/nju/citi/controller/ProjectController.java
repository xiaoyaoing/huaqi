package cn.edu.nju.citi.controller;


import cn.edu.nju.citi.service.ProjectService;
import cn.edu.nju.citi.service.UserService;
import cn.edu.nju.citi.vo.FundInvestmentVO;
import cn.edu.nju.citi.vo.FundReportVO;
import cn.edu.nju.citi.vo.ProjectVO;
import cn.edu.nju.citi.vo.ResponseVO;
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

    @Autowired
    UserService userService;

    @GetMapping("/list") //不用登陆
    public ResponseEntity<ResponseVO> getFundList(HttpSession session, @RequestHeader("uuid") String uuid) {
        return ResponseEntity.ok(projectService.getFundList());
    }

    @GetMapping("/{uuid}/detail")
    public ResponseEntity<ResponseVO> getDetail(HttpSession session, @PathVariable("uuid") String projectUuid, @RequestHeader("uuid") String apiUuid) {  //具体信息
        return ResponseEntity.ok(projectService.getDetail(projectUuid));
    }

    @PostMapping("/{uuid}/invest")
    public ResponseEntity<ResponseVO> invest(@PathVariable("uuid") String uuid, @CookieValue("session_id") String sessionID, @RequestHeader("Content-Type") String contentType, @RequestBody FundInvestmentVO fundInvestment) {
        if (sessionID == null) {
            return new ResponseEntity<>(ResponseVO.error("请先登录"), HttpStatus.BAD_REQUEST);
        }
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(projectService.invest(uuid, sessionID, fundInvestment));
    }

    @GetMapping("/{uuid}/report")
    public ResponseEntity<ResponseVO> getFundReport(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(projectService.getReport(uuid));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseVO> create(HttpSession session, @RequestHeader("uuid") String uuid, @RequestHeader("Content-Type") String contentType, @RequestBody ProjectVO project) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        return ResponseEntity.ok(projectService.create(project));
    }

    //公布已投资项目的细节
    @PostMapping("/{uuid}/report")
    public ResponseEntity<ResponseVO> postFundReport(HttpSession session, @PathVariable("uuid") String projectUuid, @RequestHeader("uuid") String apiUuid, @RequestHeader("Content-Type") String contentType, @RequestBody FundReportVO fundReport) {
        if (!contentType.equals("application/json"))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);//这里可能以后要加上ErrorObject
        return ResponseEntity.ok(projectService.postReport(projectUuid, fundReport));
    }
}
