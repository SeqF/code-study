package com.study.blog.dao;

import com.study.blog.common.dao.MapperUtil;
import com.study.blog.po.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper extends MapperUtil<Blog> {

    //根据分类、标签、是否推荐动态查询博客
    List<Blog> queryBlogByExample(@Param("typeId") Integer typeId, @Param("title") String title, @Param("recommend") Boolean recommend);
}
