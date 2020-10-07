package com.example.demo.controller;


import com.example.demo.Vo.ResponseVo;
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
    public ResponseVo AccountCreationRequest(UUID Uuid, ContentType Content_type) {
        return null;
    }

    //账户注册
    @GetMapping("/request_verification")
    public ResponseVo Verification(Cookie cookie, UUID Uuid) {
        return null;
    }

    //账户验证
    @PostMapping("/verify")
    public ResponseVo Verify(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }

    //验证验证码是否正确


    @PostMapping("/login")
    public ResponseVo User_login(UUID uuid, ContentType type) {  //Content-Type: application/json required
        return null;
    }

    //用户登陆

    @GetMapping("/info")
    public ResponseVo AccountInfo(UUID UUid, Cookie Cookie) {
        return null;
    }

    //查看账户信息


    @PostMapping("/info")
    public ResponseVo Change_accountinfo(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }


    @PostMapping("/bind")
    public ResponseVo Bind_citiaccount(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }


}
