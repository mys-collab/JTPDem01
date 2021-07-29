package com.jtp7.demo.entity.tdo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="TruckInfoDTO", description="司机信息dto表")
public class TruckInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "驾驶证号",required = true , dataType = "String")
    private String drivingCode;

    @ApiModelProperty(value = "姓名",required = true , dataType = "String")
    private String name;

    @ApiModelProperty(value = "电话", required = true , dataType = "String")
    private String phone;

    @ApiModelProperty(value = "用户名 默认为驾驶证号后6位")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱", required = true , dataType = "String")
    private String email;


}
