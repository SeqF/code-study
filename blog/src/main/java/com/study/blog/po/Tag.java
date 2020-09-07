package com.study.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;

    private List<Blog> blogs;

}
