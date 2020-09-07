package com.study.blog.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.study.blog.po.Type;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;

public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    PageInfo listType(Integer pageNum);

    int updateType(Long id,Type type);

    int deleteType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();
}
