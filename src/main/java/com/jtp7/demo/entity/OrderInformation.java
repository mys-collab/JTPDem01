package com.jtp7.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@TableName("order_information")
@ApiModel(value="OrderInformation", description="订单信息")
public class OrderInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    @ApiModelProperty(name = "orderId",value = "订单id",dataType = "Integer",required = true)
    private Integer orderId;

    /**
     * 送货地址
     */
    @ApiModelProperty(name = "address",value = "送货地址",dataType = "String",required = true)
    private String address;

    /**
     * 送货距离
     */
    @ApiModelProperty(name = "gap",value = "送货距离",dataType = "Integer",required = true)
    private Integer gap;

    /**
     * 送货日期
     */
    @ApiModelProperty(name = "date",value = "送货日期",dataType = "String",required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate date;

    /**
     * 送货时间
     */
    @ApiModelProperty(name = "time",value = "送货时间",dataType = "String",required = true)
    private String time;

    /**
     * 送货司机
     */
    @ApiModelProperty(name = "driver",value = "送货司机",dataType = "String",required = true)
    private String driver;

    /**
     * 送货卡车
     */
    @ApiModelProperty(name = "truck",value = "送货卡车",dataType = "String",required = true)
    private String truck;

    /**
     * 是否有额
     */
    @ApiModelProperty(name = "isCompensate",value = "是否有额",dataType = "Boolean",required = true)
    private Boolean isCompensate;

    /**
     * 额外奖励
     */
    @ApiModelProperty(name = "compensate",value = "额外奖励")
    private BigDecimal compensate;

    /**
     * 总价
     */
    @ApiModelProperty(name = "total",value = "总价")
    private BigDecimal total;

}
