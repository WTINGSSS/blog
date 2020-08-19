package com.czxy.service.Impl;

import com.czxy.domain.Blog;
import com.czxy.domain.PageVo;
import com.czxy.mapper.BlogMapper;
import com.czxy.mapper.CommentMapper;
import com.czxy.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2020/3/4 19:46
 * @description
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private CommentMapper commentMapper;

    @Override
    public void add(Blog blog) {
        blogMapper.add(blog);
    }

    @Override
    public PageInfo<Blog> pageForVo(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        if(pageVo.getTitle()!=null&&!"".equals(pageVo.getTitle())){
          pageVo.setTitle("%"+pageVo.getTitle()+"%");
        }

        List<Blog> blist = blogMapper.pageForVo(pageVo);
        return new PageInfo<>(blist);
    }

    @Override
    public Blog findOneById(Integer id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Blog blog) {
        blogMapper.updateByPrimaryKey(blog);
    }

    @Override
    public void deleteAll(String ids) {
        for (String s : ids.split(",")) {
            commentMapper.deleteByBlogId(s);
            blogMapper.deleteByPrimaryKey(s);
        }
    }

    @Override
    public List<Blog> findByTid(String ids) {
        List<Blog> result = null;
        for (String typeid : ids.split(",")) {
            Example example = new Example(Blog.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("typeid",typeid);
            result = blogMapper.selectByExample(example);
        }
        System.out.println(result);
        return result;
    }
}
