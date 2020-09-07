package com.study.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_type")
public class Type {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column
    @NonNull
    private String name;

    @Transient
    private List<Blog> blogs;
}
