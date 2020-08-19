package com.czxy.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 博客类型
 */
@Data
@Table(name = "t_blogtype")
public class Blogtype implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 类型名称
     */
    @Column(name = "typeName")
    private String typename;

    /**
     * 序号
     */
    @Column(name = "orderNo")
    private Integer orderno;

    /**
     * 该类型下博客数量
     */
    private Integer blogCount;

    private static final long serialVersionUID = 1L;
}