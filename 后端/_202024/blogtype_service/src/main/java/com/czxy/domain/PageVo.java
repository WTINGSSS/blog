package com.czxy.domain;

import lombok.Data;

/**
 * @author 庭前云落
 * @Date 2020/3/4 13:58
 * @description
 */
@Data
public class PageVo {

    private Integer pageNum;
    private Integer pageSize;
    private String typeName;
    private Integer start;
    private Integer end;
}
