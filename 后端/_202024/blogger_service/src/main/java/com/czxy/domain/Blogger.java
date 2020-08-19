package com.czxy.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_blogger")
public class Blogger implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 个人信息
     */
    @Column(name = "profile")
    private String profile;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 个性签名
     */
    @Column(name = "sign")
    private String sign;

    /**
     * 头像地址
     */
    @Column(name = "imageName")
    private String imagename;

    private static final long serialVersionUID = 1L;
}