package com.jtp7.demo.service;


import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.tdo.TruckinfoDTO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2021-07-28
 */
public interface LorryInfoService {

    /**
     * 根据全字段模糊查询，字段为空是默认查询所有
     *
     * @param lorryInfo
     * @return List<LorryInfo>
     */
    List<LorryInfo> getLorryInfoByLike(LorryInfo lorryInfo);

    /**
     * 新增卡车
     * @param lorryInfo
     */
    Integer add(LorryInfo lorryInfo);

    /**
     * 修改卡车
     * @param lorryInfo
     * @return
     */
    Integer updateById(LorryInfo lorryInfo);

    /**
     * 删除卡车
     * @param id
     * @return
     */
    Integer deleteById(Integer id);

}
