package com.jtp7.demo.entity.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@ToString
@NoArgsConstructor
public class ResponseResult<T> implements Response {

    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    List<T> listData;

    T data;

    //提示信息
    String message;

    //单个方法类型构造
    public ResponseResult(ResultCode resultCode,T data){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }
    //List集合类型构造
    public ResponseResult(ResultCode resultCode, List<T> datas){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.listData = datas;
    }


    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

}
