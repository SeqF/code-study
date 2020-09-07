package com.study.blog.dao;

import com.study.blog.common.dao.MapperUtil;
import com.study.blog.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMapper extends MapperUtil<Type> {

    Type  queryByTypename(String typename);

}
