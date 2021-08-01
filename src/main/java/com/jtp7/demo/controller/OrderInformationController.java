package com.jtp7.demo.controller;


import com.jtp7.demo.config.SwaggerConfiguration;
import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.dto.OrderInfoDTO;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.PageListResult;
import com.jtp7.demo.entity.response.ResponseResult;
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

    @GetMapping("/selectOrderById")
    @ApiOperation(value="根据订单ID查询订单信息,没有传参默认查询所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "OrderId", value = "订单ID,可以不传", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "currentPage", value = "当前的页码,默认1", required = false, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "没有显示的条数,默认8条", required = false, paramType = "query", dataType = "Integer")
    })
    public ResponseResult<PageListResult<OrderInformation>> findByName(@RequestParam(value = "OrderId", required = false) Integer OrderId,
                                                                @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                                @RequestParam(value = "size",required = false)  Integer size) {

        PageListResult<OrderInformation> pageListResult = iOrderInformationService.findById(OrderId,currentPage,size);
        return new ResponseResult<>(CommonCode.SUCCESS, pageListResult);
    }



    @ApiOperation(value="根据时间查询是否有可用司机")
    @ApiImplicitParam(name = "date", value = "根据时间查询是否有可用司机", required = true, paramType = "query", dataType = "String")
    @GetMapping("/findByTruck")
    public ResponseResult<TruckInfo> findByTruck(@RequestParam(value = "date", required = true) String date) {
        List<TruckInfo> ByTruck = iOrderInformationService.findByTruck(date);
        return  new ResponseResult<>(CommonCode.SUCCESS,ByTruck);
    }


    @ApiOperation(value="根据时间查询是否有可用卡车")
    @ApiImplicitParam(name = "date", value = "根据时间查询是否有可用卡车", required = true, paramType = "query", dataType = "String")
    @GetMapping("/findByLorry")
    public ResponseResult<LorryInfo> findByLorry(@RequestParam(value = "date", required = true) String date) {
        List<LorryInfo> ByLorry = iOrderInformationService.findByLorry(date);
        return  new ResponseResult<>(CommonCode.SUCCESS,ByLorry);
    }



    @ApiOperation(value="根据是否有偿状态决定是否有偿")
    @ApiImplicitParam(name = "isCompensate", value = "传入true/false", required = true, paramType = "query", dataType = "Boolean")
    @GetMapping("/isCompensate")
    public ResponseResult<Object> isCompensate(@RequestParam(value = "isCompensate", required = true) Boolean isCompensate) {
        iOrderInformationService.isCompensate(isCompensate);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }



    @PostMapping("/updateOrder")
    @ApiOperation(value="修改订单")
    public ResponseResult<Object> updateOrder(@RequestBody OrderInformation orderInformation) {
        iOrderInformationService.update(orderInformation);
        return  new ResponseResult<>(CommonCode.YES_ADD_ORDER);
    }



    @ApiOperation(value="根据id删除订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "订单id", required = true, paramType = "path", dataType = "int")
    })
    @DeleteMapping("deleteOrderById/{id}")
    public ResponseResult<Object> deleteOrderById(@PathVariable("id") Integer id) {
        iOrderInformationService.delete(id);
        return  new ResponseResult<>(CommonCode.SUCCESS);
    }



    @PostMapping("/addOrder")
    @ApiOperation(value="新增订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderInfoDTO", value = "新增订单信息", required = true, paramType = "body", dataType = "OrderInfoDTO")
    })
    public ResponseResult<Object> addOrder(@RequestBody OrderInfoDTO orderInfoDTO) {
        iOrderInformationService.add(orderInfoDTO);
        return  new ResponseResult<>(CommonCode.YES_ADD_ORDER);
    }
}
