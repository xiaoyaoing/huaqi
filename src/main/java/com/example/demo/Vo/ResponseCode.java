package com.example.demo.Vo;

public enum ResponseCode {
    BadRequest(400),//请求结果由于错误返回null
    Unauthorized(401),
    OK(200),
    CATCH_EXCEPTION(2500);//普通异常

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
