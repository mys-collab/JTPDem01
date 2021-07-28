package com.jtp7.demo.exception;


import com.jtp7.demo.entity.response.ResultCode;

//自定义的异常类
public class CustomException extends RuntimeException {

    //错误代码
         ResultCode resultCode;

//构造方法
    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
