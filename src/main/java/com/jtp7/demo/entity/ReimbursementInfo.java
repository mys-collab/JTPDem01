package com.jtp7.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@TableName("ReimbursementInfo")
@Alias("ReimbursementInfo")
public class ReimbursementInfo implements Serializable {

    private static final long serialVersionUID = -5117941044565340348L;

    /**
     * 申请人
     */
    private String applicant;

    /**
     * 类型: 汽油费：卡车维修费
     */
    private String type;

    /**
     * 申请金额
     */
    private Integer money;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 申请时间
     */
    private String applicationTime;

    /**
     * 状态: 已提交：审批通过： 驳回
     */
    private String state;
}
