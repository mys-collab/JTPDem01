package com.jtp7.demo.service;


import com.jtp7.demo.entity.Truckinfo;

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
}
