package com.czxy.controller;

import com.czxy.common.vo.BaseResult;
import com.czxy.domain.Blogtype;
import com.czxy.domain.PageVo;
import com.czxy.service.BlogtypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2020/3/4 13:55
 * @description
 */
@RestController
@RequestMapping("/blogtype")
public class BlogController {

    @Resource
    private BlogtypeService blogtypeService;


    @GetMapping
    public BaseResult ListForVo(PageVo pageVo) {
        PageInfo<Blogtype> pageInfo = blogtypeService.listForVo(pageVo);
        return BaseResult.ok("查询成功", pageInfo);
    }

    @GetMapping("/findblist")
    public BaseResult countList() {
        List<Blogtype> blist = blogtypeService.findblist();
        return BaseResult.ok("查询成功", blist);
    }

    @PostMapping
    public BaseResult add(@RequestBody Blogtype blogtype) {
        blogtypeService.add(blogtype);
        return BaseResult.ok("添加成功");
    }

    @GetMapping("/{id}")
    public BaseResult findOneById(@PathVariable("id") Integer id) {
        Blogtype blogtype = blogtypeService.findOneById(id);
        return BaseResult.ok("查询成功", blogtype);
    }

    @PutMapping
    public BaseResult update(@RequestBody Blogtype blogtype) {
        blogtypeService.update(blogtype);
        return BaseResult.ok("修改成功");
    }

    @DeleteMapping
    public BaseResult deleteAll(String ids) {
        blogtypeService.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }


}
