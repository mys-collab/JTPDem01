package com.jtp7.demo.service;

import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.OrderInformation;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.dto.OrderInfoDTO;
import com.jtp7.demo.entity.response.PageListResult;

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

    OrderInformation update(OrderInformation orderInformation);

    int delete(int id);

    OrderInfoDTO add(OrderInfoDTO orderInfoDTO);

    PageListResult<OrderInformation> findById(Integer orderId, Integer currentPage, Integer size);

    List<TruckInfo> findByTruck(String date);

    List<LorryInfo> findByLorry(String date);

    void isCompensate(Boolean isCompensate);

}
