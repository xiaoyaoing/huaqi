package com.example.demo.service.impl;

import com.example.demo.Vo.ResponseVo;
import com.example.demo.service.ProjectService;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ResponseVo getFundList() {
        return null;
    }

    @Override
    public ResponseVo getDetail(UUID uuid) {
        return null;
    }

    @Override
    public ResponseVo getReport() {
        return null;
    }

    @Override
    public ResponseVo invest(UUID uuid, Cookie cookie, ContentType type) {
        return null;
    }

    @Override
    public ResponseVo create() {
        return null;
    }
}
