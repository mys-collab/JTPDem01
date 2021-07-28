package com.jtp7.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("ReimbursementApprovalInfo")
@ApiModel(value="ReimbursementApprovalInfo", description="审批信息")
public class ReimbursementApprovalInfo implements Serializable {

    private static final long serialVersionUID = 6075267028610702827L;
    /**
     * 唯一id
     */
    @ApiModelProperty(name = "id",value = "用户 id",dataType = "Integer",required = true)
    private Integer id;
    /**
     * 状态: 已提交：审批通过： 驳回
     */
    @ApiModelProperty(name = "state",value = "申请状态",dataType = "String",required = true)
    private String state;

}
