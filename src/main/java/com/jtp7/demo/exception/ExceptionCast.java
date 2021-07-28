package com.jtp7.demo.exception;


import com.jtp7.demo.entity.response.ResultCode;

/**
 * 封装自己写的异常类,用来简化出异常的地方
 */
public class ExceptionCast {
    public  static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

}
