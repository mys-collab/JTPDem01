package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.response.PageListResult;
import com.jtp7.demo.entity.vo.AddTruckInfoDTO;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.dto.TruckInfoDTO;
import com.jtp7.demo.service.ITruckInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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
@CrossOrigin
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
    @ApiImplicitParam(name = "addTruckInfoDTO", value = "新增司机信息", required = true, paramType = "body", dataType = "AddTruckInfoDTO")
    public ResponseResult<Object> addTruckInfo(@RequestBody AddTruckInfoDTO addTruckInfoDTO ) {
       iTruckInfoService.add(addTruckInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

    @PostMapping("updateTruckInfo")
    @ApiOperation(value="修改司机信息")
    @ApiImplicitParam(name = "truckInfoDTO", value = "修改司机信息", required = true, paramType = "body", dataType = "TruckInfoDTO")
    public ResponseResult<Object> updateTruckInfo(@RequestBody TruckInfoDTO truckInfoDTO) {
        iTruckInfoService.update(truckInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

    @GetMapping("/selectTruckInfoByName")
    @ApiOperation(value="根据姓名查询司机信息,没有传参默认查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户的name,可以不传", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "currentPage", value = "当前的页码,默认1", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "没有显示的条数,默认8条", required = false, paramType = "query", dataType = "Integer")
    })
    public ResponseResult<PageListResult<TruckInfo>> findByName(@RequestParam(value = "name", required = false) String name,
                                                @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                @RequestParam(value = "size",required = false)  Integer size) {

        PageListResult<TruckInfo> pageListResult = iTruckInfoService.findByName(name,currentPage,size);
        return new ResponseResult<>(CommonCode.SUCCESS, pageListResult);
    }

    @ApiOperation(value="删除司机信息")
    @ApiImplicitParam(name = "id", value = "删除司机信息", required = true, paramType = "path", dataType = "String")
    @DeleteMapping("deleteById/{id}")
    public ResponseResult<Object> deleteTruckInfo(@PathVariable("id") String id) {
        iTruckInfoService.delete(id);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }


    @ApiOperation(value="根据状态查询司机信息")
    @ApiImplicitParam(name = "id", value = "根据状态查询司机信息", required = false, paramType = "query", dataType = "Integer")
    @GetMapping("/findByVersion")
    public ResponseResult<TruckInfo> findByVersion(@RequestParam(value = "id", required = false) Integer id) {
        if (ObjectUtils.isEmpty(id)){
            id = 0;
        }
        List<TruckInfo> byVersion = iTruckInfoService.findByVersion(id);
        return  new ResponseResult<>(CommonCode.SUCCESS,byVersion);
    }


}
