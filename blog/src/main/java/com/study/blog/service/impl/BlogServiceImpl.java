package com.study.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.blog.NotFoundException;
import com.study.blog.dao.BlogMapper;
import com.study.blog.po.Blog;
import com.study.blog.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Blog getBlog(Long id) {
        return null;
    }

    @Override
    public PageInfo<Blog> listBlog(Integer pageNum, Integer typeId,String title,Boolean recommend) {
        PageHelper.startPage(pageNum,5);
        List<Blog> blogList=blogMapper.queryBlogByExample(typeId,title,recommend);
        PageInfo<Blog> pagInfo=new PageInfo<Blog>(blogList);
        System.out.println(blogList);
        return pagInfo;
    }

    @Override
    public int saveBlog(Blog blog) {
        return blogMapper.insert(blog);
    }

    @Override
    public int updateBlog(Long id, Blog blog) {
        Blog b = blogMapper.selectByPrimaryKey(id);
        if (b == null) {
            throw new NotFoundException("该博客不存在");
        }
        //将blog已更新的对象复制给查询出来的b
        BeanUtils.copyProperties(blog,b);
        return blogMapper.updateByPrimaryKeySelective(b);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogMapper.deleteByPrimaryKey(id);
    }
}
