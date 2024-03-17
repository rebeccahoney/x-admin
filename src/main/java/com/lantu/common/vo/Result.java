package com.lantu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 无参构造
@AllArgsConstructor //全参构造

//重载
public class Result<T> {
    private Integer code;
    private String message;
    private  T data; //指的是泛型
    public static <T> Result<T> success(){

        return new Result<>(20000, "success", null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(20000,"success",data);
    }
    public static <T> Result<T> success(T data, String message){
        return new Result<>(20000,message,data);
    }
    public static <T> Result<T> success(T data, String message,Integer code){
        return new Result<>(code,message,data);
    }
    public static<T> Result<T> Fail(){
        return new Result<>(50000,"fail",null);
    }
    public static <T> Result<T> Fail(Integer code){
        return new Result<>(code, "fail",null);

    }
    public static <T> Result<T> Fail(Integer code, String message){
        return new Result<>(code,message,null);
    }
    public static <T> Result<T> Fail(String message){
        return new Result<>(50000,message,null);

    }



}
