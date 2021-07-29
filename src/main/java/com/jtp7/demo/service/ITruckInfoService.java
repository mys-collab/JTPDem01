package com.jtp7.demo.service;


import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.tdo.TruckInfoDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2021-07-27
 */
public interface ITruckInfoService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TruckInfo findById(String id);

    /**
     * 新增用户
     * @param truckInfo
     */
    TruckInfoDTO add(TruckInfoDTO truckInfo);

    /**
     * 修改用户信息
     * @param truckInfo
     * @return
     */
     TruckInfoDTO update(TruckInfoDTO truckInfo );

    /**
     * 按司机姓名进行模糊搜索
     * @param name
     * @return
     */
    List<TruckInfo> findByName(String name);

    /**
     * 查询司机状态为在岗的信息
     * @param version
     * @return
     */
    List<TruckInfo> findByVersion(int version);
    /***
     * 删除用户信息
     * @param id
     * @return
     */
    int delete(String  id);




}
