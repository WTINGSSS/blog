package com.czxy.service.Impl;

import com.czxy.domain.Blogtype;
import com.czxy.domain.PageVo;
import com.czxy.mapper.BlogtypeMapper;
import com.czxy.service.BlogtypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 庭前云落
 * @Date 2020/3/4 12:49
 * @description
 */
@Service
public class BlogtypeServiceImpl implements BlogtypeService {

    @Resource
    private BlogtypeMapper blogtypeMapper;


    @Override
    public List<Blogtype> findblist(){
        return blogtypeMapper.findblist();
    }

    @Override
    public Blogtype findOneById(Integer id){
        return blogtypeMapper.findOneById(id);
    }

    @Override
    public PageInfo<Blogtype> listForVo(PageVo pageVo){
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        if(pageVo.getTypeName()!=null&&!"".equals(pageVo.getTypeName())){
            pageVo.setTypeName("%"+pageVo.getTypeName()+"%");
        }
        List<Blogtype> list = blogtypeMapper.listForVo(pageVo);
        return new PageInfo<>(list);
    }

    @Override
    public Long getTotal(Map<String,Object> paramMap){
        return blogtypeMapper.getTotal(paramMap);
    }

    @Override
    public void add(Blogtype blogtype){
        blogtypeMapper.add(blogtype);
    }

    @Override
    public void update(Blogtype blogtype){
          blogtypeMapper.update(blogtype);
    }

    @Override
    public void deleteAll(String ids){
        for (String s : ids.split(",")) {
            blogtypeMapper.deleteByPrimaryKey(s);
        }
    }
}
