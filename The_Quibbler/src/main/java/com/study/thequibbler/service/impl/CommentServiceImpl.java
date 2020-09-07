package com.study.thequibbler.service.impl;

import com.study.thequibbler.entity.Comment;
import com.study.thequibbler.mapper.CommentMapper;
import com.study.thequibbler.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
