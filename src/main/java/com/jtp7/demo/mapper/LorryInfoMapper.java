package com.jtp7.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtp7.demo.entity.LorryInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2021-07-28
 */
@Repository
public interface LorryInfoMapper extends BaseMapper<LorryInfo> {

    List<LorryInfo> getLorryInfoByLike(LorryInfo lorryInfo);


}
