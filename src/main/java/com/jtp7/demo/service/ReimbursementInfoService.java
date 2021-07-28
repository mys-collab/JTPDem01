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
     * 根据全字段模糊查询，字段为空是默认查询所有
     *
     * @param reimbursementInfo
     * @return List<ReimbursementInfo>
     */
    List<ReimbursementInfo> getReimbursementInfoByLike(ReimbursementInfo reimbursementInfo);

    /**
     * 报销申请提交
     * @param reimbursementInfo
     * @return int
     */
    Integer claimForReimbursement(ReimbursementInfo reimbursementInfo);

    /**
     * 报销审批
     * @param reimbursementApprovalInfo
     * @return List<ReimbursementInfo>
     */
    Integer reimbursementApproval(ReimbursementApprovalInfo reimbursementApprovalInfo);

}
