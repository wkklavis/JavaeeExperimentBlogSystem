package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回前端的数据封装
 */
@Data
public class ReturnResult {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

    public ReturnResult(boolean success, int code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ReturnResult returnSuccess(Object data){
        return new ReturnResult(true ,200,"success",data);
    }
    public static ReturnResult returnFail(int code,String msg){
        return new ReturnResult(false ,code,"fail",null);
    }


}
