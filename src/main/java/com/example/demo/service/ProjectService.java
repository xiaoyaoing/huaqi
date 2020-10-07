package com.example.demo.service;


import com.example.demo.Vo.ProjectForm;
import com.example.demo.Vo.ResponseVo;


public interface ProjectService {
    ResponseVo getFundList();

    ResponseVo getDetail(String uuid);

    ResponseVo getReport(String uuid);

    ResponseVo invest(String uuid, String sessionID, String contentType);

    ResponseVo create(String uuid, String contentType, ProjectForm vo);
}
