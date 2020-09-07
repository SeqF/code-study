package com.study.mapper;

import com.study.pojo.User;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test(){
        //获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        //执行sql
        //方式一： getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user:userList){
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserListLike(){

        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        List<User> userList=mapper.getUserListLike("boss");

        for (User user:userList){
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void geyUserById(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int res=mapper.addUser(new User(4,"boss4","1234345"));

        if(res>=0){
            System.out.println("插入成功");
        }

        //提交事务,增删改必须要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map=new HashMap<String, Object>();

        map.put("userid",5);
        map.put("username","jluzh");
        map.put("password","1swqeqwasa");

        mapper.addUser2(map);

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        int res=mapper.updateUser(new User(1,"miss","22222"));

        if(res>0){
            System.out.println("更新成功");
        }

        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);

        if(res>0){
            System.out.println("删除成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
