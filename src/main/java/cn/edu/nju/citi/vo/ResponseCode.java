package cn.edu.nju.citi.vo;

public enum ResponseCode {
    SUCCESS(0),
    ERROR(-1);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
