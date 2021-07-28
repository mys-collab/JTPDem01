package com.jtp7.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@TableName("order_information")
public class OrderInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 送货距离
     */
    private Integer gap;

    /**
     * 送货日期
     */
    private LocalDate date;

    /**
     * 送货时间
     */
    private String time;

    /**
     * 送货司机
     */
    private String driver;

    /**
     * 送货卡车
     */
    private String truck;

    /**
     * 是否有额
     */
    private Boolean isCompensate;

    /**
     * 额外奖励
     */
    private BigDecimal compensate;

    /**
     * 总价
     */
    private BigDecimal total;

}
