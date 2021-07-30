package com.jtp7.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jtp7.demo.entity.TruckInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.dto.TruckInfoDTO;
import com.jtp7.demo.entity.response.PageListResult;
import com.jtp7.demo.entity.vo.AddTruckInfoDTO;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.TruckInfoMapper;
import com.jtp7.demo.service.ITruckInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2021-07-27
 */
@Slf4j
@Service
@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
public class TruckInfoServiceImpl implements ITruckInfoService {

    @Autowired
    private TruckInfoMapper truckInfoMapper;

    /**
     * 根据id查询
     *
     * @param id
     */
    @Override
    public TruckInfo findById(String id) {
        return truckInfoMapper.selectById(id);
    }

    /**
     * 新增用户
     */
    @Override
    public AddTruckInfoDTO add(AddTruckInfoDTO addTruckInfoDTO) {
        TruckInfoDTO truckInfoDTO = new TruckInfoDTO();
        BeanUtils.copyProperties(addTruckInfoDTO, truckInfoDTO);

        if (!ObjectUtils.isEmpty(this.drivingCodeIsNull(truckInfoDTO))) {
            ExceptionCast.cast(CommonCode.NO_ADD_TRUCKINFO);
        }

        TruckInfo truckInfo = new TruckInfo();
        BeanUtils.copyProperties(truckInfoDTO, truckInfo);

        String code = this.getDrivingCodeAndAfterSix(truckInfoDTO.getDrivingCode());
        truckInfo.setUsername(code);
        truckInfo.setVersion(0);
        truckInfoMapper.insert(truckInfo);
        return addTruckInfoDTO;
    }

    /**
     * 修改司机信息
     *
     * @return
     */
    @Override
    public TruckInfoDTO update(TruckInfoDTO truckInfoDto) {
        if (ObjectUtils.isEmpty(truckInfoDto.getDrivingCode())) {
            ExceptionCast.cast(CommonCode.DRIVINGCODE_ISNULL);
        }

        TruckInfo truckInfoOne = this.findById(truckInfoDto.getId());
        if (ObjectUtils.isEmpty(truckInfoOne) ||
                ObjectUtils.isEmpty(truckInfoOne.getDrivingCode()) ||
                ObjectUtils.isEmpty(truckInfoDto.getDrivingCode())) {
            ExceptionCast.cast(CommonCode.NO_TRUCKINFO);
        }

        //如果身份证号码一样就可以进行修改
        if (truckInfoOne.getDrivingCode().equals(truckInfoDto.getDrivingCode())) {
            TruckInfo truckInfo = new TruckInfo();
            BeanUtils.copyProperties(truckInfoDto, truckInfo);
            truckInfoMapper.update(truckInfo, null);
            return truckInfoDto;
        } else {
            ExceptionCast.cast(CommonCode.NO_TRUCKINFO);
        }
        return null;
    }

    /**
     * 截取身份证后6位
     *
     * @param drivingcode
     * @return
     */
    private String getDrivingCodeAndAfterSix(String drivingcode) {
        return drivingcode.substring(drivingcode.length() - 6);
    }

    /**
     * 是否身份证已存在
     *
     * @param truckInfoDTO
     * @return
     */
    private TruckInfo drivingCodeIsNull(TruckInfoDTO truckInfoDTO) {
        LambdaQueryWrapper<TruckInfo> truckInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        truckInfoLambdaQueryWrapper.eq(TruckInfo::getDrivingCode, truckInfoDTO.getDrivingCode());
        return truckInfoMapper.selectOne(truckInfoLambdaQueryWrapper);
    }

    /**
     * 按司机姓名进行模糊搜索
     *
     * @param name
     * @return
     */
    @Override
    public PageListResult<TruckInfo> findByName(String name, Integer currentPage, Integer size) {
        if (ObjectUtils.isEmpty(currentPage)) {
            currentPage = 1;
        }
        if (ObjectUtils.isEmpty(size)) {
            size = 8;
        }

        LambdaQueryWrapper<TruckInfo> wrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(name)) {
            wrapper.like(TruckInfo::getName, name);
        }
        Page<TruckInfo> page = truckInfoMapper.selectPage(new Page<>(currentPage, size), wrapper);
        PageListResult<TruckInfo> pageListResult = new PageListResult<>();
        pageListResult.setList(page.getRecords());
        pageListResult.setTotal(page.getTotal());
        return pageListResult;
    }

    /**
     * 查询司机状态为在岗的信息
     *
     * @param version
     * @return
     */
    @Override
    public List<TruckInfo> findByVersion(int version) {

        LambdaQueryWrapper<TruckInfo> truckInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        truckInfoLambdaQueryWrapper.eq(TruckInfo::getVersion, version);
        return truckInfoMapper.selectList(truckInfoLambdaQueryWrapper);
    }

    /***
     * @param id
     *删除信息
     *
     * @return
     */
    @Override
    public int delete(String id) {
        return truckInfoMapper.deleteById(id);
    }

}
