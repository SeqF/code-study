package com.study.blog.service;

import com.github.pagehelper.PageInfo;
import com.study.blog.po.Blog;

public interface BlogService {

    Blog getBlog(Long id);

    PageInfo<Blog> listBlog(Integer pageNum,Integer typeId,String title,Boolean recommend);

    int saveBlog(Blog blog);

    int updateBlog(Long id,Blog blog);

    int deleteBlog(Long id);

}
