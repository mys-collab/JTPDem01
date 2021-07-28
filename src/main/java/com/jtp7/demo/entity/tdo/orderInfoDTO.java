package com.jtp7.demo.entity.tdo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author 赵志文
 * @date 2021/7/28
 */
@Data
@ApiModel(value="orderInfoDTO", description="订单信息DTO表")
public class orderInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "送货地址")
    private String address;

    @ApiModelProperty(value = "送货距离")
    private Integer gap;

    @ApiModelProperty(value = "送货日期")
    private LocalDate date;

    @ApiModelProperty(value = "送货时间")
    private String time;

    @ApiModelProperty(value = "送货司机")
    private String driver;

    @ApiModelProperty(value = "送货卡车")
    private String truck;

    @ApiModelProperty(value = "是否有额")
    private Boolean isCompensate;

    @ApiModelProperty(value = "额外奖励")
    private BigDecimal compensate;



}
