package com.edu.nju.citi.VO;


public class ResponseVO {
    private ResponseCode code;

    private String message;

    private Object data;

    public ResponseVO(Object data) {
        this.code = ResponseCode.SUCCESS;
        this.data = data;
    }

    public ResponseVO(ResponseCode code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseVO(ResponseCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseVO error(Object reason) {
        return new ResponseVO(ResponseCode.ERROR, reason);
    }

    public static ResponseVO ok() {
        return new ResponseVO(null);
    }

    public static ResponseVO ok(Object data) {
        return new ResponseVO(data);
    }

}
