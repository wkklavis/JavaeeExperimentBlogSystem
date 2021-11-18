package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回前端的统一错误信息
 */
@AllArgsConstructor
public enum Error {

    //通用错误类型00001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),

    //10000开头为为用户信息相关的错误定义
    USER_NOT_EXIST(20001,"用户不存在"),

    WRONG_PASSWORD(20002,"密码错误"),
    USER_EXISTED(20003,"用户已存在"),
    NOT_LOGGING(10000,"未登录");

    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

