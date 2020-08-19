package com.czxy.mapper;

import com.czxy.domain.Bvo;
import com.czxy.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper extends tk.mybatis.mapper.common.Mapper<Comment> {

    @Select("SELECT * FROM t_comment")
    @Results(id = "r1",value = {
            @Result(property = "blogid",column = "blogId"),
            @Result(property = "blog",column = "blogId",one = @One(select = "com.czxy.mapper.BlogMapper.selectByPrimaryKey"))
    })
    List<Comment> pageForVo(@Param("vo") Bvo bvo);


    @Select("SELECT * FROM t_comment WHERE state=0")
    @ResultMap("r1")
    List<Comment> ListForstate(@Param("vo") Bvo bvo);

    @Delete("DELETE FROM t_comment WHERE blogId = #{blogId}")
    void deleteByBlogId(@Param("blogId") String s);
}