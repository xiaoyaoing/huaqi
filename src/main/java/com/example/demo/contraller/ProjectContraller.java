package com.example.demo.contraller;


import com.example.demo.Vo.ResponseVo;
import com.example.demo.service.ProjectService;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fund")
public class ProjectContraller {


    @GetMapping("/list")
    public ResponseVo get_fundlist(UUID uuid)  //不用登陆
    {
        return ProjectService.get_fund_list();
    }


    @GetMapping("/detail")
    public  ResponseVo get_detail(UUID uuid) {  //具体信息
        return  ProjectService.get_deatil( uuid);
    }


    @PostMapping("/invest")
    public  ResponseVo invest_fund(UUID uuid, Cookie cookie, ContentType type){
        return  ProjectService.invest( uuid,  cookie, type);
    }


    @GetMapping("/report")
    public  ResponseVo get_fundreport(UUID uuid){
        return ProjectService.get_report();
    }

}
