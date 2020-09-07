package com.study.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.blog.NotFoundException;
import com.study.blog.dao.TypeMapper;
import com.study.blog.po.Type;
import com.study.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    TypeMapper typeMapper;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.insert(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public PageInfo listType(Integer pageNum) {

        //第一个参数从哪一页开始
        PageHelper.startPage(pageNum,5);
        List<Type> typelist=typeMapper.selectAll();
        PageInfo<Type> pageInfo=new PageInfo<Type>(typelist);
        return pageInfo;
    }

    @Transactional
    @Override
    public int updateType(Long id, Type type) {

        Type t=typeMapper.selectByPrimaryKey(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeMapper.insert(t);
    }

    @Transactional
    @Override
    public int deleteType(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.queryByTypename(name);
    }

    @Override
    public List<Type> listType() {
        return typeMapper.selectAll();
    }
}
