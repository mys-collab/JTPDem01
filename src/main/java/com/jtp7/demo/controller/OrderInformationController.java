package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.entity.dto.OrderInfoDTO;
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
@CrossOrigin(allowedHeaders ="*")
@Api(value = "订单信息表", tags = {SwaggerConfiguration.TAG_4})
public class OrderInformationController {

    @Autowired
    private IOrderInformationService iOrderInformationService;


    @GetMapping("/findAllOrders")
    @ApiOperation(value="查询所有订单信息")
    public ResponseResult<OrderInformation> findAllOrders() {
        List<OrderInformation> allOrders = iOrderInformationService.findAllOrders();
        return new ResponseResult(CommonCode.SUCCESS, allOrders);
    }

    @PostMapping("/getOrderByLike")
    @ApiOperation(value = "根据全字段查询订单信息，为空时查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderInformation", value = "订单信息", required = true, paramType = "body", dataType = "OrderInformation")
    })
    public ResponseResult<List<OrderInformation>> getOrderByLike(@RequestBody OrderInformation orderInformation){
        List<OrderInformation> information = iOrderInformationService.getOrderByLike(orderInformation);
        return new ResponseResult<List<OrderInformation>>(CommonCode.SUCCESS,information);
    }

    @PostMapping("/updateOrder")
    @ApiOperation(value="修改订单信息")
    @ApiImplicitParam(name = "OrderInfoDTO", value = "修改订单信息", required = true, paramType = "body", dataType = "OrderInfoDTO")
    public ResponseResult<Object> updateOrder(@RequestBody OrderInfoDTO orderInfoDTO) {
        iOrderInformationService.update(orderInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_ORDER);
    }



    @ApiOperation(value="根据id删除订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单id", required = true, paramType = "path", dataType = "Integer")
    })
    @DeleteMapping("deleteOrderById/{id}")
    public ResponseResult<Object> deleteOrderById(@PathVariable("id") Integer id) {
        iOrderInformationService.delete(id);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }



    @PostMapping("/addOrder")
    @ApiOperation(value="新增订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OrderInfoDTO", value = "新增订单信息", required = true, paramType = "body", dataType = "OrderInfoDTO")
    })
    public ResponseResult<Object> addOrder(@RequestBody OrderInfoDTO orderInfoDTO) {
        iOrderInformationService.add(orderInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_ORDER);
    }
}
