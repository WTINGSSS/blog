package com.czxy.service;

import com.czxy.domain.Bvo;
import com.czxy.domain.Comment;
import com.github.pagehelper.PageInfo;

/**
 * @author 庭前云落
 * @Date 2020/3/5 15:40
 * @description
 */
public interface CommentService {

    PageInfo<Comment> pageForVo(Bvo bvo);

    void deleteAll(String ids);

    PageInfo ListForstate(Bvo bvo);

    void examint(String ids);

    void examinf(String ids);
}
