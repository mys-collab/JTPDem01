package com.jtp7.demo.service;

import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.dto.OrderInfoDTO;

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

    OrderInfoDTO update(OrderInfoDTO orderInfoDTO);

    int delete(int id);

    OrderInfoDTO add(OrderInfoDTO orderInfoDTO);

    List<OrderInformation> getOrderByLike(OrderInformation orderInformation);
}
