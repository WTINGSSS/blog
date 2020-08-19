package com.czxy.service;

import com.czxy.domain.Blog;
import com.czxy.domain.PageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 庭前云落
 * @Date 2020/3/4 19:48
 * @description
 */
public interface BlogService {
    void add(Blog blog);

    PageInfo<Blog> pageForVo(PageVo pageVo);

    Blog findOneById(Integer id);

    void update(Blog blog);

    void deleteAll(String ids);

    List<Blog> findByTid(String ids);
}
