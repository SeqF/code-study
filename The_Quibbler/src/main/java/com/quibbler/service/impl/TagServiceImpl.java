package com.quibbler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quibbler.mapper.TagMapper;
import com.quibbler.model.entity.Tag;
import com.quibbler.service.TagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Paksu
 * @since 2020-07-13
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
