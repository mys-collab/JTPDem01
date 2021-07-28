package com.jtp7.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ReimbursementInfo")
@Alias("ReimbursementInfo")
@ApiModel(value="ReimbursementInfo", description="报销信息")
public class ReimbursementInfo implements Serializable {

    private static final long serialVersionUID = -5117941044565340348L;

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id",value = "用户 id",dataType = "Integer",required = true)
    private Integer id;

    /**
     * 驾驶证号
     */
    @ApiModelProperty(name = "driving_code",value = "驾驶证号",dataType = "String",required = true)
    private String driving_code;

    /**
     * 申请人
     */
    @ApiModelProperty(name = "applicant",value = "申请人姓名",dataType = "String",required = true)
    private String applicant;

    /**
     * 类型: 汽油费：卡车维修费
     */
    @ApiModelProperty(name = "type",value = "报销类型: 汽油费&卡车维修费",dataType = "String",required = true)
    private String type;

    /**
     * 申请金额
     */
    @ApiModelProperty(name = "money",value = "报销金额",dataType = "Integer",required = true)
    private Integer money;

    /**
     * 月份
     */
    @ApiModelProperty(name = "month",value = "报销月份",dataType = "Integer",required = true)
    private Integer month;

    /**
     * 申请时间
     */
    @ApiModelProperty(name = "applicationTime",value = "申请时间",dataType = "String",required = true)
    private String applicationTime;

    /**
     * 状态: 已提交：审批通过： 驳回
     */
    @ApiModelProperty(name = "state",value = "申请状态",dataType = "String",required = true)
    private String state;
}
