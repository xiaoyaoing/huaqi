package com.edu.nju.citi.VO;


public class ResponseVO<T> {
    private ResponseCode code;

    private T data;

    public ResponseVO(T data) {
        this.code = ResponseCode.SUCCESS;
        this.data = data;
    }

    public ResponseVO(ResponseCode code, T data) {
        this.code = code;
        this.data = data;
    }

    public static ResponseVO<String> error(String reason) {
        return new ResponseVO<>(ResponseCode.ERROR, reason);
    }

    public static ResponseVO ok() {
        return new ResponseVO(null);
    }

    public static ResponseVO<String> ok(String data) {
        return new ResponseVO<>(data);
    }

}
