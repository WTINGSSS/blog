package com.czxy.service.Impl;

import com.czxy.domain.Bvo;
import com.czxy.domain.Comment;
import com.czxy.mapper.CommentMapper;
import com.czxy.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 庭前云落
 * @Date 2020/3/5 15:39
 * @description
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> pageForVo(Bvo bvo) {
        PageHelper.startPage(bvo.getPageNum(),bvo.getPageSize());

        List<Comment> clist = commentMapper.pageForVo(bvo);
        return new PageInfo<>(clist);
    }

    @Override
    public void deleteAll(String ids) {
        for (String s : ids.split(",")) {
            commentMapper.deleteByPrimaryKey(s);
        }
    }

    @Override
    public PageInfo ListForstate(Bvo bvo) {
        PageHelper.startPage(bvo.getPageNum(),bvo.getPageSize());
        List<Comment> clist = commentMapper.ListForstate(bvo);
        return new PageInfo(clist);
    }

    @Override
    public void examint(String ids) {
        for (String s : ids.split(",")) {
            Comment comment = commentMapper.selectByPrimaryKey(s);
            comment.setState(1);
            commentMapper.updateByPrimaryKey(comment);
        }
    }

    @Override
    public void examinf(String ids) {
        for (String s : ids.split(",")) {
            Comment comment = commentMapper.selectByPrimaryKey(s);
            comment.setState(2);
            commentMapper.updateByPrimaryKey(comment);
        }
    }
}
