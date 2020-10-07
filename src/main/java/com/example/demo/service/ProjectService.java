package com.example.demo.service;


import com.example.demo.Vo.ResponseVo;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;

import javax.servlet.http.Cookie;
import java.util.UUID;


public interface ProjectService {
    ResponseVo getFundList();

    ResponseVo getDetail(UUID uuid);

    ResponseVo getReport();

    ResponseVo invest(UUID uuid, Cookie cookie, ContentType type);

    ResponseVo create();
}
