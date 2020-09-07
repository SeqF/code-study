package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.study.pojo.User;
import com.study.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller //走视图解析器 ,配合@ResponseBody使用
@RestController //全部方法都是返回字符串
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody  //它就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //jackson   ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        //创建一个对象
        User user=new User(1,"台湾No.1",1);
        String str=mapper.writeValueAsString(user); //用objmapper将对象转换为string

        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        List<User> userList=new ArrayList<User>();

        User user1=new User(1,"台湾No.1",1);
        User user2=new User(1,"台湾No.2",1);
        User user3=new User(1,"台湾No.3",1);
        User user4=new User(1,"台湾No.4",1);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        return JsonUtils.getJson(userList);
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        Date date=new Date();
        //ObjectMapper,时间解析后的默认格式为:Timestamp,时间戳
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:MM:SS");
    }

    @RequestMapping("/j4")
    public String json4(){

        List<User> userList=new ArrayList<User>();

        User user1=new User(1,"台湾No.1",1);
        User user2=new User(1,"台湾No.2",1);
        User user3=new User(1,"台湾No.3",1);
        User user4=new User(1,"台湾No.4",1);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str=JSON.toJSONString(userList);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "hello";
    }
}
