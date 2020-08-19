package com.czxy.mapper;

import com.czxy.domain.Blog;
import com.czxy.domain.PageVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper extends tk.mybatis.mapper.common.Mapper<Blog> {


    @Insert("INSERT INTO t_blog VALUES (null,#{blog.title},#{blog.summary},now(),0,0,#{blog.content},#{blog.typeid},#{blog.keyword})")
    void add(@Param("blog") Blog blog);


    @Select("<script>" +
            "SELECT * FROM t_blog WHERE 1=1" +
            "<if test=\" vo.title!=null and vo.title!=null \"> and title like  #{vo.title}</if>"+
            "</script>")
    @Results({
            @Result(property = "typeid",column = "typeId"),
            @Result(property = "blogtype",column = "typeId",one = @One(select = "com.czxy.mapper.BlogtypeMapper.selectByPrimaryKey"))
})
    List<Blog> pageForVo(@Param("vo") PageVo pageVo);
}