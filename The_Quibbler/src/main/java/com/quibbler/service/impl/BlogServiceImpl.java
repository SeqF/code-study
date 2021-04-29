package com.quibbler.service.impl;

import com.quibbler.entity.Blog;
import com.quibbler.mapper.BlogMapper;
import com.quibbler.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
