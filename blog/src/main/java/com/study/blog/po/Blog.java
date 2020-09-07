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
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String headPicture;
    @Column
    private String flag;//记录是转载还是原创
    @Column
    private Integer views;
    @Column
    private boolean appreciation;
    @Column
    private boolean shareStatement;
    @Column
    private boolean comment;
    @Column
    private boolean published;
    @Column
    private boolean recommended;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
//    @Column
//    private Long typeId;
//    @Column
//    private Long userId;

    @Transient
    private Type type;
    @Transient
    private User user;
    @Transient
    private List<Tag> tags;
    @Transient
    private List<Comment> comments;
}
