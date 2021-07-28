package com.jtp7.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.entity.Truckinfo;
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
public interface ReimbursementInfoMapper extends BaseMapper<ReimbursementInfo> {
    List<ReimbursementInfo> getReimbursementInfoByLike(ReimbursementInfo reimbursementInfo);
}
