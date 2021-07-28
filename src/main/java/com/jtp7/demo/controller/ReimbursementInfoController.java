package com.jtp7.demo.controller;

import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.service.ReimbursementInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@Api(value = "报销申请表", tags = {SwaggerConfiguration.TAG_2})
public class ReimbursementInfoController {
    @Autowired
    private ReimbursementInfoService reimbursementInfoService;

    @PostMapping("/reimbursementInfo")
    @ApiOperation(value = "根据全字段查询报销信息，为空时查询所有")
    public ResponseResult<List<ReimbursementInfo>> getReimbursementInfoByLike(@RequestBody ReimbursementInfo reimbursementInfo){
        List<ReimbursementInfo> ReimbursementInfos = reimbursementInfoService.getReimbursementInfoByLike(reimbursementInfo);
        return new ResponseResult<List<ReimbursementInfo>>(CommonCode.SUCCESS,ReimbursementInfos);
    }
    @PostMapping("/claimForReimbursement")
    @ApiOperation(value = "报销申请")
    public ResponseResult<Integer> claimForReimbursement(@RequestBody ReimbursementInfo reimbursementInfo) {

        Integer integer = reimbursementInfoService.claimForReimbursement(reimbursementInfo);
        return new ResponseResult<Integer>(CommonCode.SUCCESS,integer);
    }

}
