package com.jtp7.demo.service;

import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.tdo.orderInfoDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WuWeiJia
 * @since 2021-07-28
 */
public interface IOrderInformationService{
    /**
     * 查询全部订单记录
     *
     *
     * @return
     */
    List<OrderInformation> findAllOrders();

    orderInfoDTO update(orderInfoDTO orderInfoDTO);

    int delete(int id);

    orderInfoDTO add(orderInfoDTO orderInfoDTO);
}
