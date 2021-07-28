package com.jtp7.demo.service;


import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.tdo.TruckinfoDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2021-07-27
 */
public interface ITruckinfoService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Truckinfo findById(int id);

    /**
     * 新增用户
     * @param truckinfo
     */
    TruckinfoDTO add(TruckinfoDTO truckinfo);

    /**
     * 修改用户信息
     * @param truckinfo
     * @return
     */
     TruckinfoDTO update(TruckinfoDTO truckinfo );
}
