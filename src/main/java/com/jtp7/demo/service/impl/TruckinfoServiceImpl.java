package com.jtp7.demo.service.impl;

import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.TruckinfoMapper;
import com.jtp7.demo.service.ITruckinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2021-07-27
 */
@Slf4j
@Service
@Transactional
public class TruckinfoServiceImpl implements ITruckinfoService {

    @Autowired
    private TruckinfoMapper truckinfoMapper;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Truckinfo findById(int id) {
        Truckinfo truckinfoDTO = truckinfoMapper.selectById(id);
        if (truckinfoDTO == null ) {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return truckinfoDTO;
    }
}
