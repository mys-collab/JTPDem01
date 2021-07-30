package com.jtp7.demo.controller;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.Users;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;

import com.jtp7.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "用户信息表", tags = {SwaggerConfiguration.TAG_4})
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Select("/User")
    @ApiOperation(value="查询所有用户信息")
    public ResponseResult<OrderInformation> findAllOrders() {
        List<Users> Userslist = userInfoService.selectUserlist();
        return new ResponseResult(CommonCode.SUCCESS, Userslist);
    }

    @Select("/User")
    @ApiImplicitParam(name = "users", value = "修改用户信息", required = true, paramType = "body", dataType = "Users")
    public ResponseResult<Object> selectUserById(@RequestBody Users users) {
        Users users1 = userInfoService.selectUserById(users);
        return new ResponseResult(CommonCode.SUCCESS,users1) ;
    }

    @Update("/User")
    @ApiOperation(value="修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "修改用户信息", required = true, paramType = "body", dataType = "Users")
    })
    public ResponseResult<Object> updateUser(@RequestBody Users users) {
        if (userInfoService.updateUserById(users) == 0) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }

    @ApiOperation(value="删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "删除用户信息", required = true, paramType = "body", dataType = "Users")
    })
    @Delete("/User")
    public ResponseResult<Object> deleteUser(@RequestBody Users users) {
        if (userInfoService.deleteUserById(users) == 0) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }

    @Insert("/User")
    @ApiOperation(value="新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "新增用户信息", required = true, paramType = "body", dataType = "Users")
    })
    public ResponseResult<Object> insertUser(@RequestBody Users users) {
        if ( userInfoService.insertUser(users) == 0) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }


}
