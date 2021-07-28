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

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("lorryinfo")
@Alias("LorryInfo")
@ApiModel(value="LorryInfo", description="卡车信息")
public class LorryInfo {

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id",value = "用户 id",dataType = "Integer",required = true)
    private Integer id;

    /**
     * 车牌号
     */
    @ApiModelProperty(name = "license",value = "车牌号",dataType = "String",required = true)
    private String license;

    /**
     * 卡车状态,0：正常，1：维修，2：报废
     */
    @ApiModelProperty(name = "state",value = "卡车状态,0：正常，1：维修，2：报废",dataType = "String",required = true)
    private String state;

}
