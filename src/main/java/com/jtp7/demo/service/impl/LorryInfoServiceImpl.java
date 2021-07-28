package com.jtp7.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jtp7.demo.entity.LorryInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.response.ResponseResult;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.LorryInfoMapper;
import com.jtp7.demo.service.LorryInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2021-07-28
 */
@Slf4j
@Service
@Transactional
public class LorryInfoServiceImpl implements LorryInfoService {

    @Autowired
    private LorryInfoMapper lorryInfoMapper;


    /**
     * 根据全字段模糊查询，字段为空是默认查询所有
     *
     * @param lorryInfo
     * @return List<LorryInfo>
     */
    @Override
    public List<LorryInfo> getLorryInfoByLike(LorryInfo lorryInfo) {
        List<LorryInfo> lorryInfos = lorryInfoMapper.getLorryInfoByLike(lorryInfo);
        if (lorryInfos == null ) {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return lorryInfos;
    }

    /**
     * 新增卡车
     * @param lorryInfo
     */
    @Override
    public Integer add(LorryInfo lorryInfo) {
        if (!ObjectUtils.isEmpty(this.LicenseIsNull(lorryInfo.getLicense()))){
            ExceptionCast.cast(CommonCode.NO_ADD_LORRY);
        }
        return lorryInfoMapper.insert(lorryInfo);
    }

    /**
     * 通过id更新
     * @param lorryInfo
     */
    @Override
    public Integer updateById(LorryInfo lorryInfo) {
        if (!ObjectUtils.isEmpty(this.LicenseIsNull(lorryInfo.getLicense()))){
            ExceptionCast.cast(CommonCode.NO_ADD_LORRY);
        }
        return lorryInfoMapper.updateById(lorryInfo);
    }

    /**
     * 删除卡车
     * @param id
     * @return Integer
     */
    @Override
    public Integer deleteById(Integer id) {
        return lorryInfoMapper.deleteById(id);
    }

    /**
     * 通过状态查询
     * @param state
     * @return LorryInfo
     */
    @Override
    public List<LorryInfo>  getLorryInfoByState(String state) {
        QueryWrapper<LorryInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",state);
        System.out.println(1);
        List<LorryInfo>  lorryInfo = lorryInfoMapper.selectList(queryWrapper);
        return lorryInfo;
    }

    /**
     * 是否车牌已存在
     * @param license
     * @return LorryInfo
     */
    private LorryInfo LicenseIsNull(String license) {
        QueryWrapper<LorryInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("license",license);
        LorryInfo lorryInfo = lorryInfoMapper.selectOne(queryWrapper);
        return lorryInfo;
    }

}
