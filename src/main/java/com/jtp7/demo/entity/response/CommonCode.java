package com.jtp7.demo.entity.response;

import lombok.ToString;

/**
 * 通用返回需要什么自己添加
 * @author 梅玉松
 */
@ToString
public enum CommonCode implements ResultCode{
    //可以自己添加异常信息
    INFO(false,10003,"非法参数"),
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统!"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    NO_ADD_TRUCKINFO(false,10003,"该司机已存在！"),
    YES_ADD_TRUCKINFO(true,10004,"保存成功！"),
     DRIVINGCODE_ISNULL(false,10005,"身份证号为空"),
     NO_TRUCKINFO(false,10006,"还没有该用户"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");


    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
