package com.jtp7.demo.exception;

import com.google.common.collect.ImmutableMap;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jtp7.demo.entity.response.CommonCode;


/**
 *统一的异常捕获类
 */
@ControllerAdvice // 控制器增强的注解
public class ExceptionCatch{
        //日志
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>, ResultCode>ExCEPTIONS;

    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder=
            ImmutableMap.builder();


    //类启动先加载,构建到ExCEPTIONS里面
    static {
        //定义了异常类型所对应的错误代码
        builder.put(HttpRequestMethodNotSupportedException.class,CommonCode.INFO);
        builder.put(HttpRequestMethodNotSupportedException.class,CommonCode.ILLEGAL_REQUEST);
    }


    /**
     * 自定义异常
     * @param customException
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult handlerCustomException(CustomException customException){
        //记录日志
        LOGGER.error("catch exception:()",customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    /**
     * 未知异常的处理
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handlerException(Exception exception){
        //记录日志
        LOGGER.error("catch exception:()",exception.getMessage(),exception);

        if (ExCEPTIONS == null ){
            ExCEPTIONS = builder.build(); // 构建 ExCEPTIONS
        }

        //从ExCEPTIONS中找异常类型所对应的错误代码,如果找到了将错误代码返回
        ResultCode resultCode = ExCEPTIONS.get(exception.getClass());
        if (resultCode !=null){
            return  new ResponseResult(resultCode);
        }else {
            //系统繁忙异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }



}
