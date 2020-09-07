package com.study.blog.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column
    private String nickname;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String avatar;
    @Column
    private Integer type;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    @Transient
    private List<Blog> blogs;
}
