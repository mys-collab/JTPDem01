package com.jtp7.demo.entity.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private  T data;
    //数据总数
    private long total;
}
