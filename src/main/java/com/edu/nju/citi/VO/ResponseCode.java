package com.edu.nju.citi.VO;

public enum ResponseCode {
    SUCCESS(0),
    ERROR(-1);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
