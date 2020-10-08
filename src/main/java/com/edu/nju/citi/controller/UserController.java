package com.edu.nju.citi.controller;


import com.edu.nju.citi.VO.ResponseVO;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account") //domain为网站的域名
public class UserController {
    //cookie 用来判断用户是否登陆，但采用什么类存疑
    @PostMapping("/create")
    public ResponseVO AccountCreationRequest(UUID Uuid, ContentType Content_type) {
        return null;
    }

    //账户注册
    @GetMapping("/request_verification")
    public ResponseVO Verification(Cookie cookie, UUID Uuid) {
        return null;
    }

    //账户验证
    @PostMapping("/verify")
    public ResponseVO Verify(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }

    //验证验证码是否正确


    @PostMapping("/login")
    public ResponseVO User_login(UUID uuid, ContentType type) {  //Content-Type: application/json required
        return null;
    }

    //用户登陆

    @GetMapping("/info")
    public ResponseVO AccountInfo(UUID UUid, Cookie Cookie) {
        return null;
    }

    //查看账户信息


    @PostMapping("/info")
    public ResponseVO Change_accountinfo(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }


    @PostMapping("/bind")
    public ResponseVO Bind_citiaccount(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }


}
