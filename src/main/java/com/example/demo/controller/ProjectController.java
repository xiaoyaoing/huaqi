package com.example.demo.controller;


import com.example.demo.Vo.ResponseVo;
import com.example.demo.service.ProjectService;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fund")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/list") //不用登陆
    public ResponseVo getFundList(UUID uuid) {
        return projectService.getFundList();
    }

    @GetMapping("/detail")
    public ResponseVo getDetail(UUID uuid) {  //具体信息
        return projectService.getDetail(uuid);
    }


    @PostMapping("/invest")
    public ResponseVo investFund(UUID uuid, Cookie cookie, ContentType type) {
        return projectService.invest(uuid, cookie, type);
    }

    @GetMapping("/report")
    public ResponseVo getFundReport(UUID uuid) {
        return projectService.getReport();
    }

}
