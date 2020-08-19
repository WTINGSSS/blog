package com.czxy.mapper;

import com.czxy.domain.Blogtype;
import com.czxy.domain.PageVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogtypeMapper extends tk.mybatis.mapper.common.Mapper<Blogtype> {

    /**
     * 无参数查询所有博客类型列表
     */
    @Select("SELECT t2.id,t2.typeName,COUNT(t1.id) AS blogCount,t2.orderNo FROM t_blog t1 RIGHT JOIN t_blogtype t2 ON t1.typeId=t2.id GROUP BY t2.typeName ORDER BY t2.orderNo")
    public List<Blogtype> findblist();

    /**
     * 根据id查询博客类型
     */
    @Select("SELECT * FROM t_blogtype WHERE  id=#{id}")
    public Blogtype findById(@Param("id") Integer id);

    /**
     * 条件查询博客类型列表
     */
    @Select("<script>" +
            "SELECT * FROM t_blogtype" +
            "<if test=\" vo.typeName!=null and vo.typeName!='' \"> and typeName like #{vo.typeName} </if>"+
            "<if test=\" vo.start!=null and vo.end!=null \"> and limit #{vo.start},${vo.end} </if>"+
            "</script>")
    public List<Blogtype> listForVo(@Param("vo") PageVo pageVo);

    /**
     * 查询博客类型数
     */
    @Select("SELECT COUNT(*) FROM t_blogtype")
     public Long getTotal(@Param("vo2") Map<String,Object> paramMap);


    @Insert("INSERT INTO t_blogtype(typeName, orderNo) VALUES (#{blogtype.typename},#{blogtype.orderno})")
    void add(@Param("blogtype") Blogtype blogtype);

    @Select("SELECT * FROM t_blogtype WHERE id=#{id}")
    Blogtype findOneById(@Param("id") Integer id);

    @Update("UPDATE t_blogtype SET typeName =#{blogtype.typename},orderNo=#{blogtype.orderno} WHERE id=#{blogtype.id}")
    void update(@Param("blogtype") Blogtype blogtype);
}