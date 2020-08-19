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
@Table(name = "t_comment")
public class Comment implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 评论者IP
     */
    @Column(name = "userIp")
    private String userip;

    /**
     * 被评论博客的主键
     */
    @Column(name = "blogId")
    private Integer blogid;

    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 评论时间
     */
    @Column(name = "commentDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date commentdate;

    /**
     * 评论状态：0未审核1审核
     */
    @Column(name = "`state`")
    private Integer state;

    //每条评论对应一个博客
    private Blog blog;

    private static final long serialVersionUID = 1L;
}