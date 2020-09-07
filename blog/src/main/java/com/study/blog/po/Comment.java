package com.study.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String nickname;
    private String content;
    private String avatar;
    private Date creatTime;

    private Blog blog;
    /*一个评论包含多个回复*/
    private List<Comment> replyComments;
    /*一个回复只对应一个评论*/
    private Comment parentComment;
}
