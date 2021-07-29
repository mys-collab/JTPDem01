package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.tdo.TruckInfoDTO;
import com.jtp7.demo.service.ITruckInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
 * @since 2021-07-27
 */
@Slf4j
@RestController
@Api(value = "司机信息表", tags = {SwaggerConfiguration.TAG_1})
public class TruckInfoController {

    @Autowired
    private ITruckInfoService iTruckInfoService;

    @GetMapping("/TruckInfo/{id}")
    @ApiOperation(value="根据id查询司机信息")
   @ApiImplicitParam(name = "id", value = "用户的id", required = true, paramType = "path", dataType = "String")
    public ResponseResult<TruckInfo> findById(@PathVariable("id")String id) {
        TruckInfo TruckInfo = iTruckInfoService.findById(id);
        return new ResponseResult(CommonCode.SUCCESS, TruckInfo);
    }

    @PostMapping("addTruckInfo")
    @ApiOperation(value="新增司机")
    @ApiImplicitParam(name = "TruckInfoDTO", value = "新增司机信息", required = true, paramType = "body", dataType = "TruckInfoDTO")
    public ResponseResult<Object> addTruckInfo(@RequestBody TruckInfoDTO TruckInfoDTO) {
       iTruckInfoService.add(TruckInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

    @PostMapping("updateTruckInfo")
    @ApiOperation(value="修改司机信息")
    @ApiImplicitParam(name = "TruckInfoDTO", value = "修改司机信息", required = true, paramType = "body", dataType = "TruckInfoDTO")
    public ResponseResult<Object> updateTruckInfo(@RequestBody TruckInfoDTO TruckInfoDTO) {
        iTruckInfoService.update(TruckInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

    @GetMapping("/selectTruckInfoByName/{name}")
    @ApiOperation(value="根据姓名查询司机信息")
    @ApiImplicitParam(name = "name", value = "用户的name", required = true, paramType = "path", dataType = "String")
    public ResponseResult<TruckInfo> findByName(@PathVariable("name") String name) {
        List<TruckInfo> truckInfo = iTruckInfoService.findByName(name);
        return new ResponseResult<>(CommonCode.SUCCESS, truckInfo);
    }

    @ApiOperation(value="删除司机信息")
    @ApiImplicitParam(name = "id", value = "删除司机信息", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("deleteById/{id}")
    public ResponseResult<Object> deleteTruckInfo(@PathVariable("id") String id) {
        iTruckInfoService.delete(id);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }

}
