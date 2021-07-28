package com.jtp7.demo.service.impl;

import com.jtp7.demo.entity.ReimbursementInfo;
import com.jtp7.demo.entity.response.CommonCode;
import com.jtp7.demo.exception.ExceptionCast;
import com.jtp7.demo.mapper.ReimbursementInfoMapper;
import com.jtp7.demo.service.ReimbursementInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ReimbursementInfoServiceImpl implements ReimbursementInfoService {
    @Autowired
    ReimbursementInfoMapper reimbursementInfoMapper;

    /**
     * 根据全字段模糊查询，字段为空是默认查询所有
     *
     * @param reimbursementInfo
     * @return List<ReimbursementInfo>
     */
    @Override
    public List<ReimbursementInfo> getReimbursementInfoByLike(ReimbursementInfo reimbursementInfo) {
        List<ReimbursementInfo> reimbursementInfoList = reimbursementInfoMapper.getReimbursementInfoByLike(reimbursementInfo);
        if (reimbursementInfoList == null ) {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return reimbursementInfoList;
    }

    @Override
    public Integer claimForReimbursement(ReimbursementInfo reimbursementInfo) {
        //默认申请时间
        reimbursementInfo.setApplicationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Integer result = reimbursementInfoMapper.insert(reimbursementInfo);
        if (result == 0) {
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return result;
    }
}
