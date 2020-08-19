package com.czxy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "t_blog")
public class Blog implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 摘要
     */
    @Column(name = "summary")
    private String summary;

    /**
     * 发表时间
     */
    @Column(name = "releaseDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releasedate;

    /**
     * 点击数
     */
    @Column(name = "clickHit")
    private Integer clickhit;

    /**
     * 评论数
     */
    @Column(name = "replyHit")
    private Integer replyhit;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 所属博客典型
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 关键字
     */
    @Column(name = "keyWord")
    private String keyword;

    private Blogtype blogtype;

    private static final long serialVersionUID = 1L;
}