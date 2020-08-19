package com.czxy.controller;

import com.czxy.common.vo.BaseResult;
import com.czxy.domain.Bvo;
import com.czxy.domain.Comment;
import com.czxy.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 庭前云落
 * @Date 2020/3/5 15:41
 * @description
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    @GetMapping
    public BaseResult pageForVo(Bvo bvo){
        PageInfo<Comment> pageInfo = commentService.pageForVo(bvo);
        return BaseResult.ok("查询成功",pageInfo);
    }

    @DeleteMapping
    public BaseResult deleteAll(String ids){
        commentService.deleteAll(ids);
        return BaseResult.ok("删除成功");
    }

    @GetMapping("/ListForstate")
    public BaseResult ListForstate(Bvo bvo){
        PageInfo pageInfo = commentService.ListForstate(bvo);
    return BaseResult.ok("查询成功",pageInfo);
    }

    @GetMapping("/examint")
    public BaseResult examint(String ids){
      commentService.examint(ids);
      return BaseResult.ok("操作成功");
    }

    @GetMapping("/examinf")
    public BaseResult examinf(String ids){
        commentService.examinf(ids);
        return BaseResult.ok("操作成功");
    }
}
