package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;

import com.jtp7.demo.entity.Users;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;

import com.jtp7.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户信息表", tags = {SwaggerConfiguration.TAG_5})
public class UsersController {

    @Autowired
    private UserInfoService userInfoService;


    @ApiOperation(value="查询所有用户信息")
    @GetMapping
    public ResponseResult<Users> selectUserList() {
        List<Users> Userslist = userInfoService.selectUserlist();
        return new ResponseResult(CommonCode.SUCCESS, Userslist);
    }

    @GetMapping(value="/{username}")
    @ApiOperation(value="查找用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "查找用户信息", required = true, paramType = "path", dataType = "String")
    })
    public ResponseResult<Object> selectUserById(@PathVariable String username) {
        Users users = new Users();
        users.setUsername(username);
        Users users1 = userInfoService.selectUserById(users);
        return new ResponseResult(CommonCode.SUCCESS,users1) ;
    }

    @PutMapping
    @ApiOperation(value="修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "修改用户信息", required = true, paramType = "body", dataType = "Users")
    })
    public ResponseResult<Object> updateUser(@RequestBody Users users) {
        if (userInfoService.updateUserById(users) != -1) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }

    @DeleteMapping(value="/{username}")
    @ApiOperation(value="删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "删除用户信息", required = true, paramType = "body", dataType = "Users")
    })
    public ResponseResult<Object> deleteUser(@PathVariable String username) {
        Users users = new Users();
        users.setUsername(username);
        if (userInfoService.deleteUserById(users) != -1) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }

    @PostMapping
    @ApiOperation(value="新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "users", value = "新增用户信息", required = true, paramType = "body", dataType = "Users")
    })
    public ResponseResult<Object> insertUser(@RequestBody Users users) {
        if ( userInfoService.insertUser(users) != -1) return  new ResponseResult<>(CommonCode.SUCCESS);
        else return new ResponseResult<>(CommonCode.FAIL);
    }


}
