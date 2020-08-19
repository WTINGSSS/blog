package com.czxy.mapper;

import com.czxy.domain.Blogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BloggerMapper extends tk.mybatis.mapper.common.Mapper<Blogger> {
    @Select("SELECT * FROM t_blogger WHERE userName=#{blogger.username} AND password=#{blogger.password}")
    Blogger login(@Param("blogger") Blogger blogger);
}