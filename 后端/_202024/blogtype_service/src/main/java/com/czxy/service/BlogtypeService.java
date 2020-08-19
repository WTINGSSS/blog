package com.czxy.service;

import com.czxy.domain.Blogtype;
import com.czxy.domain.PageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 庭前云落
 * @Date 2020/3/4 12:50
 * @description
 */
public interface BlogtypeService {

    List<Blogtype> findblist();

    Blogtype findOneById(Integer id);

    PageInfo<Blogtype> listForVo(PageVo pageVo);

    Long getTotal(Map<String,Object> paramMap);

    void add(Blogtype blogtype);

    void update(Blogtype blogtype);

    void deleteAll(String ids);
}
