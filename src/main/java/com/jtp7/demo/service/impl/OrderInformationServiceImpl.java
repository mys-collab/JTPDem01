package com.jtp7.demo.service.impl;

import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.dto.OrderInfoDTO;
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
    BigDecimal Compensate;
    int i = 0;

    /**
     * 查询所有订单
     *
     * @return
     */
    @Override
    public List<OrderInformation> findAllOrders() {
        List<OrderInformation> orderInformations = orderInformationMapper.selectList(null);
        if(orderInformations==null && orderInformations.size()<=0){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return orderInformations;
    }

    /**
     * 对订单更新
     *
     * @param orderInfoDTO
     * @return
     */
    @Override
    public OrderInfoDTO update(OrderInfoDTO orderInfoDTO) {

        if(orderInfoDTO.getDate() != null){

            truckinfos = iTruckinfoService.findByVersion(0);
            if (truckinfos.isEmpty()){
                ExceptionCast.cast(CommonCode.FAIL_ORDER_TRUCK);
            }
            List<LorryInfo> lorryInfoByState = lorryInfoService.getLorryInfoByState("0");
            if (lorryInfoByState.isEmpty()){
                ExceptionCast.cast(CommonCode.FAIL_ORDER_LORRY);
            }
            Compensate = BigDecimal.valueOf(i);
            if (orderInfoDTO.getIsCompensate() == false){
                orderInfoDTO.setCompensate(Compensate);
            }
            OrderInformation orderInformation = new OrderInformation();
            BeanUtils.copyProperties(orderInfoDTO,orderInformation);
            orderInformationMapper.update(orderInformation,null);
            return orderInfoDTO;
        }
        
        return null;
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
        if(orderInfoDTO.getDate() != null){

            truckinfos = iTruckinfoService.findByVersion(0);
            if (truckinfos.isEmpty()){
                ExceptionCast.cast(CommonCode.FAIL_ORDER_TRUCK);
            }
            List<LorryInfo> lorryInfoByState = lorryInfoService.getLorryInfoByState("0");
            if (lorryInfoByState.isEmpty()){
                ExceptionCast.cast(CommonCode.FAIL_ORDER_LORRY);
            }
            BigDecimal Compensate;
            Compensate = BigDecimal.valueOf(i);
            if (orderInfoDTO.getIsCompensate() == false){
                orderInfoDTO.setCompensate(Compensate);
            }
            OrderInformation orderInformation = new OrderInformation();
            BeanUtils.copyProperties(orderInfoDTO,orderInformation);
            orderInformationMapper.insert(orderInformation);
            return orderInfoDTO;
        }
        return null;
    }
}
