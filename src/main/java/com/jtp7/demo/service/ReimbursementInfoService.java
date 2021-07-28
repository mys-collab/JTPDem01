package com.jtp7.demo.service;


import com.jtp7.demo.entity.ReimbursementApprovalInfo;
import com.jtp7.demo.entity.ReimbursementInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2021-07-28
 */
public interface ReimbursementInfoService {

    /**
     * 根据id查询
     * @param reimbursementInfo
     * @return List<ReimbursementInfo>
     */
    List<ReimbursementInfo> getReimbursementInfoByLike(ReimbursementInfo reimbursementInfo);

    /**
     * 报销申请
     * @param reimbursementInfo
     * @return int
     */
    Integer claimForReimbursement(ReimbursementInfo reimbursementInfo);

    /**
     * 根据id来修改审批状态
     * @param id,state
     * @return List<ReimbursementInfo>
     */
    Integer reimbursementApproval(ReimbursementApprovalInfo reimbursementApprovalInfo);

}
