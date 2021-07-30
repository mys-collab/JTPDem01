package com.jtp7.demo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="AddTruckInfoDTO", description="Add司机信息dto表")
public class AddTruckInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "驾驶证号",required = true , dataType = "String")
    private String drivingCode;

    @ApiModelProperty(value = "姓名",required = true , dataType = "String")
    private String name;

    @ApiModelProperty(value = "电话", required = true , dataType = "String")
    private String phone;


    @ApiModelProperty(value = "邮箱", required = true , dataType = "String")
    private String email;

}
