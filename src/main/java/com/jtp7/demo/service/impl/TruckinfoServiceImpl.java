package com.jtp7.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jtp7.demo.entity.Truckinfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.entity.tdo.TruckinfoDTO;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.TruckinfoMapper;
import com.jtp7.demo.service.ITruckinfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
     */
    @Override
    public Truckinfo findById(int id) {

        Truckinfo truckinfoDTO = truckinfoMapper.selectById(id);
        if (truckinfoDTO == null ) {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return truckinfoDTO;
    }

    /**
     * 新增用户
     *
     */
    @Override
    public TruckinfoDTO add(TruckinfoDTO truckinfoDTO) {

        if (!ObjectUtils.isEmpty(this.DrivingCodeIsNull(truckinfoDTO))) {
            ExceptionCast.cast(CommonCode.NO_ADD_TRUCKINFO);
        }

        Truckinfo truckinfo = new Truckinfo();
        BeanUtils.copyProperties(truckinfoDTO,truckinfo);

        String code = this.getDrivingCodeAndAfterSix(truckinfoDTO.getDrivingcode());
        truckinfo.setUsername(code);
        truckinfo.setVersion(0);
        truckinfoMapper.insert(truckinfo);
        return truckinfoDTO;
    }

    /**
     * 修改司机信息
     * @param truckinfoDto
     * @return
     */
    @Override
    public TruckinfoDTO update(TruckinfoDTO truckinfoDto ){
        if (ObjectUtils.isEmpty(truckinfoDto.getDrivingcode())){
            ExceptionCast.cast(CommonCode.DRIVINGCODE_ISNULL);
        }

        Truckinfo truckinfoOne = this.findById(truckinfoDto.getId());
        if (ObjectUtils.isEmpty(truckinfoOne) || ObjectUtils.isEmpty(truckinfoOne.getDrivingcode()) || ObjectUtils.isEmpty(truckinfoDto.getDrivingcode())){
            ExceptionCast.cast(CommonCode.NO_TRUCKINFO);
        }

        //如果身份证号码一样就可以进行修改
        if (truckinfoOne.getDrivingcode().equals(truckinfoDto.getDrivingcode())) {
            Truckinfo truckinfo = new Truckinfo();
            BeanUtils.copyProperties(truckinfoDto,truckinfo);
            truckinfoMapper.update(truckinfo,null);
            return truckinfoDto;
        }else {
            ExceptionCast.cast(CommonCode.NO_TRUCKINFO);
        }
        return null;
    }

    /**
     * 截取身份证后6位
     * @param drivingcode
     * @return
     */
    private  String getDrivingCodeAndAfterSix(String drivingcode) {
        return drivingcode.substring(drivingcode.length()-6,drivingcode.length());
    }

    /**
     * 是否身份证已存在
     * @param truckinfoDTO
     * @return
     */
    private Truckinfo DrivingCodeIsNull(TruckinfoDTO truckinfoDTO) {
        LambdaQueryWrapper<Truckinfo> truckinfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        truckinfoLambdaQueryWrapper.eq(Truckinfo::getDrivingcode,truckinfoDTO.getDrivingcode());
        Truckinfo truckinfo1 = truckinfoMapper.selectOne(truckinfoLambdaQueryWrapper);
        return truckinfo1;
    }
    /**
     * 按司机姓名进行模糊搜索
     * @param name
     * @return
     */
    public List<Truckinfo> findByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", name);
        List<Truckinfo> truckinfoList = truckinfoMapper.selectList(queryWrapper);
        return truckinfoList;
    }
}
