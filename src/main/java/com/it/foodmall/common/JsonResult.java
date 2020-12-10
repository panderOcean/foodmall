package com.it.foodmall.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class JsonResult<T> {

    private T data;

    private String code;

    private String msg;

    //成功时，且有data数据返回
    public JsonResult (String msg,T data){
        this.code = "200";
        this.msg = msg;
        this.data = data;
    }

    //成功时，不返回data数据
    public JsonResult(String msg){
        this.code = "200";
        this.msg = msg;
    }

    //失败调用的构造函数
    public JsonResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static <T>JsonResult<T> success(String msg,T data){
        return new JsonResult<>(msg,data);
    }

    public static <T>JsonResult<T> success(String msg){
        return  new JsonResult<>(msg);
    }

    public static <T>JsonResult error(String code ,String msg){
        return  new JsonResult(code,msg);
    }
}
