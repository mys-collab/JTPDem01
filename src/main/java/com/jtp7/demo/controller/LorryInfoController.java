package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.service.LorryInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2021-07-28
 */
@Slf4j
@RestController
@CrossOrigin
@Api(value = "卡车信息表", tags = {SwaggerConfiguration.TAG_3})
public class LorryInfoController {

    @Autowired
    private LorryInfoService lorryInfoService;

    @PostMapping("/getLorryInfoByLike")
    @ApiOperation(value = "根据全字段查询卡车信息，为空时查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lorryInfo", value = "卡车信息", required = true, paramType = "body", dataType = "LorryInfo")
    })
    public ResponseResult<List<LorryInfo>> getLorryInfoByLike(@RequestBody LorryInfo lorryInfo){
        List<LorryInfo> lorryInfoByLike = lorryInfoService.getLorryInfoByLike(lorryInfo);

        lorryInfoByLike.forEach((a)->{
            System.out.println(a);
        });

        return new ResponseResult<List<LorryInfo>>(CommonCode.SUCCESS,lorryInfoByLike);
    }

    @PostMapping("/add")
    @ApiOperation(value="新增卡车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lorryInfo", value = "新增卡车信息", required = true, paramType = "body", dataType = "LorryInfo")
    })
    public ResponseResult<Object> add(@RequestBody LorryInfo lorryInfo) {
        lorryInfoService.add(lorryInfo);
        return  new ResponseResult<>(CommonCode.YES_ADD_LORRYINFO);
    }

    @PostMapping("/updateById")
    @ApiOperation(value="修改司机信息")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "lorryInfo", value = "修改卡车信息", required = true, paramType = "body", dataType = "LorryInfo")
    })
    public ResponseResult<LorryInfo> updateById(@RequestBody LorryInfo lorryInfo) {
        lorryInfoService.updateById(lorryInfo);
        return  new ResponseResult<>(CommonCode.YES_ADD_LORRYINFO);
    }

    @GetMapping("/deleteById/{id}")
    @ApiOperation(value="根据id删除卡车信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "卡车的id", required = true, paramType = "path", dataType = "Integer")
    })
    public ResponseResult<Integer> deleteById(@PathVariable("id") Integer id) {
        Integer integer = lorryInfoService.deleteById(id);
        return new ResponseResult(CommonCode.SUCCESS, integer);
    }

    @GetMapping("/getLorryInfoByState/{state}")
    @ApiOperation(value="根据卡车状态查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "卡车状态", required = true, paramType = "path", dataType = "String")
    })
    public ResponseResult<List<LorryInfo>> getLorryInfoByState(@PathVariable("state")String state) {
        List<LorryInfo> info = lorryInfoService.getLorryInfoByState(state);
        return new ResponseResult(CommonCode.SUCCESS, info);
    }
}
