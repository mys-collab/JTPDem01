package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.tdo.orderInfoDTO;
import com.jtp7.demo.service.IOrderInformationService;
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
 *  前端控制器
 * </p>
 *
 * @author WuWeiJia
 * @since 2021-07-28
 */
@Slf4j
@RestController
@Api(value = "订单信息表", tags = {SwaggerConfiguration.TAG_3})
public class OrderInformationController {

    @Autowired
    private IOrderInformationService iOrderInformationService;

    @GetMapping("/findAllOrders")
    @ApiOperation(value="查询所有订单信息")
    public ResponseResult<OrderInformation> findAllOrders() {
        List<OrderInformation> allOrders = iOrderInformationService.findAllOrders();
        return new ResponseResult(CommonCode.SUCCESS, allOrders);
    }

    @PostMapping("/updateOrderInfo")
    @ApiOperation(value="修改订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderInfoDTO", value = "修改订单信息", required = true, paramType = "body", dataType = "orderInfoDTO")
    })
    public ResponseResult<Object> updateOrderInfo(@RequestBody orderInfoDTO orderInfoDTO) {
        iOrderInformationService.update(orderInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_ORDER);
    }

    @ApiOperation(value="删除订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "删除订单信息", required = true, paramType = "path", dataType = "int")
    })
    @DeleteMapping("deleteOrderInfo/{id}")
    public ResponseResult<Object> deleteTruckInfo(@PathVariable("id") int id) {
        iOrderInformationService.delete(id);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }

    @PostMapping("/addOrderInfo")
    @ApiOperation(value="新增订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderInfoDTO", value = "新增订单信息", required = true, paramType = "body", dataType = "orderInfoDTO")
    })
    public ResponseResult<Object> addOrderInfo(@RequestBody orderInfoDTO orderInfoDTO) {
        iOrderInformationService.add(orderInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_TRUCKINFO);
    }
}
