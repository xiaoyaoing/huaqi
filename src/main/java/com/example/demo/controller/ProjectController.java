package com.example.demo.controller;


import com.example.demo.Vo.ProjectForm;
import com.example.demo.Vo.ResponseVo;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//要不要考虑一下全部用HttpServletRequest来交互？
@RestController
@RequestMapping("/api/v1/fund")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    //这里的uuid是什么的uuid？
    //这里的uuid是请求的uuid，用于标识请求，应该是从header里边提取
    @GetMapping("/list") //不用登陆
    public ResponseVo getFundList(@RequestHeader("uuid") String uuid) {
        return projectService.getFundList();
    }

    //uuid是在url中还是在http请求头中？
    //如果是header就用@RequestHeader
    //如果是url就用@RequestParam
    //在url里
    @GetMapping("/{uuid}/detail")
    public ResponseVo getDetail(@PathVariable("uuid") String uuid) {  //具体信息
        return projectService.getDetail(uuid);
    }

    //uuid同上
    @PostMapping("/{uuid}/invest")
    public ResponseVo invest(@PathVariable("uuid") String uuid, @CookieValue("session_id") String sessionID, @RequestHeader("Content-Type") String contentType) {
        return projectService.invest(uuid, sessionID, contentType);
    }

    @GetMapping("/{uuid}/report")
    public ResponseVo getFundReport(@PathVariable("uuid") String uuid) {
        return projectService.getReport(uuid);
    }

    @PostMapping("/create")
    public ResponseVo create(@RequestParam("uuid") String uuid, @RequestHeader("Content-Type") String contentType, @RequestBody ProjectForm vo) {
        return projectService.create(uuid, contentType, vo);
    }


}
