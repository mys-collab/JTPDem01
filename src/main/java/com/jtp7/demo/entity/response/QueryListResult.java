package com.jtp7.demo.entity.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryListResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
