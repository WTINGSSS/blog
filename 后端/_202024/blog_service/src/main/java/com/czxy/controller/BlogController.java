package com.czxy.controller;

import com.czxy.common.vo.BaseResult;
import com.czxy.domain.Blog;
import com.czxy.domain.PageVo;
import com.czxy.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2020/3/4 19:48
 * @description
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @PostMapping
    public BaseResult add(@RequestBody Blog blog) {
        blogService.add(blog);
        return BaseResult.ok("发布成功");
    }

    @GetMapping
    public BaseResult pageForVo(PageVo pageVo) {
        PageInfo<Blog> pageInfo = blogService.pageForVo(pageVo);
        return BaseResult.ok("查询成功", pageInfo);
    }

    @GetMapping("/{id}")
    public BaseResult findOneById(@PathVariable Integer id) {
        Blog blog = blogService.findOneById(id);
        return BaseResult.ok("查询成功", blog);
    }

    @PutMapping
    public BaseResult update(@RequestBody Blog blog){
        blogService.update(blog);
        return BaseResult.ok("修改成功");
    }

    @DeleteMapping
    public BaseResult deleteAll(String ids){
        blogService.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }

    @GetMapping("/findByTid")
    public BaseResult findByTid(String ids){
       List<Blog> b = blogService.findByTid(ids);
        return  BaseResult.ok("查询成功",b);
    }
}
