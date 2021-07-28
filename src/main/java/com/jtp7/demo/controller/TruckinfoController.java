package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.tdo.TruckinfoDTO;
import com.jtp7.demo.service.ITruckinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class TruckinfoController {

    @Autowired
    private ITruckinfoService iTruckinfoService;

    @GetMapping("/truckinfo/{id}")
    @ApiOperation(value="根据id查询司机信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的id", required = true, paramType = "path", dataType = "Integer")
    })
    public ResponseResult<Truckinfo> findById(@PathVariable("id") Integer id) {
        Truckinfo truckinfo = iTruckinfoService.findById(id);
        return new ResponseResult(CommonCode.SUCCESS, truckinfo);
    }

    @PostMapping("addtruckinfo")
    @ApiOperation(value="新增司机")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truckinfoDTO", value = "新增司机信息", required = true, paramType = "body", dataType = "TruckinfoDTO")
    })
    public ResponseResult<Object> addTruckInfo(@RequestBody TruckinfoDTO truckinfoDTO) {
       iTruckinfoService.add(truckinfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

    @PostMapping("updatetruckinfo")
    @ApiOperation(value="修改司机信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truckinfoDTO", value = "修改司机信息", required = true, paramType = "body", dataType = "TruckinfoDTO")
    })
    public ResponseResult<Object> updataTruckInfo(@RequestBody TruckinfoDTO truckinfoDTO) {
       iTruckinfoService.update(truckinfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }

}
