package com.jtp7.demo.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageListResult<T> {

    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
