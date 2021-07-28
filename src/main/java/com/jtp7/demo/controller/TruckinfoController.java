package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.service.ITruckinfoService;
import com.jtp7.demo.service.ReimbursementInfoService;
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
    public ResponseResult<Truckinfo> fidnById(@PathVariable("id") Integer id) {
        Truckinfo byId = iTruckinfoService.findById(id);
        return new ResponseResult(CommonCode.SUCCESS, byId);
    }

}
