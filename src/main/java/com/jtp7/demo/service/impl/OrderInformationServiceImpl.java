package com.jtp7.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.dto.OrderInfoDTO;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.PageListResult;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.OrderInformationMapper;
import com.jtp7.demo.service.IOrderInformationService;
import com.jtp7.demo.service.ITruckInfoService;
import com.jtp7.demo.service.LorryInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WuWeiJia
 * @since 2021-07-28
 */
@Slf4j
@Service
@Transactional(rollbackFor = {RuntimeException.class,Exception.class})
public class OrderInformationServiceImpl implements IOrderInformationService {

    @Autowired
    private OrderInformationMapper orderInformationMapper;

    @Autowired
    private ITruckInfoService iTruckinfoService;

    @Autowired
    private LorryInfoService lorryInfoService;

    List<TruckInfo> truckinfos;
    List<LorryInfo> lorryInfoByState;

    /**
     * 在更新过程中调用此方法，确定是否有订单与之对应
     * @param orderId
     * @return
     */
    public OrderInformation findByIdd(Integer orderId){
        return orderInformationMapper.selectById(orderId);
    }

    /**
     * 对订单更新
     *
     * @param orderInformation
     * @return
     */
    @Override
    public OrderInformation update(OrderInformation orderInformation) {
        if (orderInformation.getOrderId() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        OrderInformation byIdd = this.findByIdd(orderInformation.getOrderId());
        if (byIdd == null){
            ExceptionCast.cast(CommonCode.NO_ORDERINFO);
        }
        if (orderInformation.getDate() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getAddress() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getTotal() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getDriver() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getTruck() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getGap() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInformation.getTime() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (!orderInformation.getIsCompensate()){
            BigDecimal bigDecimal = BigDecimal.valueOf(0);
            orderInformation.setCompensate(bigDecimal);
        }
        orderInformationMapper.updateById(orderInformation);
        return orderInformation;
    }

    /**
     *根据订单id删除订单
     *
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        int row=orderInformationMapper.deleteById(id);
        if (row==0){
            ExceptionCast.cast(CommonCode.NO_ORDERINFO);
        }
        return row;
    }



    /**
     * 增加一条订单
     *
     * @param orderInfoDTO
     * @return
     */
    @Override
    public OrderInfoDTO add(OrderInfoDTO orderInfoDTO) {
        if (orderInfoDTO.getDate() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getAddress() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getTotal() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getDriver() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getTruck() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getGap() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (orderInfoDTO.getTime() == null){
            ExceptionCast.cast(CommonCode.FAIL_INCOMPLETE_INFORMATION);
        }
        if (!orderInfoDTO.getIsCompensate()){
            BigDecimal bigDecimal = BigDecimal.valueOf(0);
            orderInfoDTO.setCompensate(bigDecimal);
        }
            OrderInformation orderInformation = new OrderInformation();
            BeanUtils.copyProperties(orderInfoDTO,orderInformation);
            orderInformationMapper.insert(orderInformation);
            return orderInfoDTO;
    }



    /**
     * 按订单ID进行模糊搜索
     *
     * @param orderId
     * @return
     */
    @Override
    public PageListResult<OrderInformation> findById(Integer orderId, Integer currentPage, Integer size) {
        if (ObjectUtils.isEmpty(currentPage)) {
            currentPage = 1;
        }
        if (ObjectUtils.isEmpty(size)) {
            size = 8;
        }

        LambdaQueryWrapper<OrderInformation> wrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(orderId)) {
            wrapper.like(OrderInformation::getOrderId, orderId);
        }
        Page<OrderInformation> page = orderInformationMapper.selectPage(new Page<>(currentPage, size), wrapper);
        PageListResult<OrderInformation> pageListResult = new PageListResult<>();
        pageListResult.setList(page.getRecords());
        pageListResult.setTotal(page.getTotal());
        return pageListResult;
    }


    /**
     * 根据时间查询是否有可用司机
     *
     * @param date
     * @return
     */
    @Override
    public List<TruckInfo> findByTruck(String date) {
        if(date != null) {
            truckinfos = iTruckinfoService.findByVersion(0);
            if (truckinfos.isEmpty()) {
                ExceptionCast.cast(CommonCode.FAIL_ORDER_TRUCK);
            }
            return truckinfos;
        }
        return null;
    }



    /**
     * 根据时间查询是否有可用卡车
     *
     * @param date
     * @return
     */
    @Override
    public List<LorryInfo> findByLorry(String date) {
        if(date != null) {
            lorryInfoByState = lorryInfoService.getLorryInfoByState("0");
            if (lorryInfoByState.isEmpty()) {
                ExceptionCast.cast(CommonCode.FAIL_ORDER_LORRY);
            }
            return lorryInfoByState;
        }
        return null;
    }




    /**
     * 根据是否有偿状态决定是否有偿
     */
    @Override
    public void isCompensate(Boolean isCompensate) {
        if (!isCompensate){
            ExceptionCast.cast(CommonCode.FAIL_IS_COMPENSATE);
        }
    }
}
