package com.jtp7.demo.service.impl;

import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.tdo.orderInfoDTO;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.OrderInformationMapper;
import com.jtp7.demo.service.IOrderInformationService;
import com.jtp7.demo.service.ITruckinfoService;
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
@Transactional
public class OrderInformationServiceImpl implements IOrderInformationService {

    @Autowired
    private OrderInformationMapper orderInformationMapper;

    @Autowired
    private ITruckinfoService iTruckinfoService;

    @Autowired
    private LorryInfoService lorryInfoService;

    List<Truckinfo> truckinfos;
    BigDecimal Compensate;
    int i = 0;

    @Override
    public List<OrderInformation> findAllOrders() {
        List<OrderInformation> orderInformations = orderInformationMapper.selectList(null);
        if(orderInformations==null && orderInformations.size()<=0){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return orderInformations;
    }


    @Override
    public orderInfoDTO update(orderInfoDTO orderInfoDTO) {

        if(orderInfoDTO.getDate() != null){

            truckinfos = iTruckinfoService.findbyVersion(0);
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

    @Override
    public int delete(int id) {
        int row=orderInformationMapper.deleteById(id);
        if (row==0){
            ExceptionCast.cast(CommonCode.NO_ORDERINFO);
        }
        return row;
    }

    @Override
    public orderInfoDTO add(orderInfoDTO orderInfoDTO) {
        if(orderInfoDTO.getDate() != null){

            truckinfos = iTruckinfoService.findbyVersion(0);
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
