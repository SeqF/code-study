package com.study.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//使用JPA注解配置映射关系
@Entity  //告诉JPA这是一个实体类
@Table(name="tbl_user") //@Table来指定和哪个数据表对应；如果省略默认表名就是users
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name="last_name",length = 50)//这是和数据表对应的一个列
    private String lastName;

    @Column //省略默认列名就是属性名
    private float money;
}
