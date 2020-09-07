package com.study.springcloud.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {

    private long deptno;
    private String dname;

    //这个数据在哪个数据库的字段，微服务，一个服务对应一个数据库
    private String db_source;

    public Dept(String dname){
        this.dname=dname;
    }

    /*
    * 链式写法：
    *     Dept dept = new Dept();
    *     dept.setDpetNo(11).setDname('sss').setDb_source('001');*/
}
