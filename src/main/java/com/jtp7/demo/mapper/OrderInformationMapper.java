package com.jtp7.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtp7.demo.entity.OrderInformation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WuWeiJia
 * @since 2021-07-28
 */
@Repository
public interface OrderInformationMapper extends BaseMapper<OrderInformation> {

}
