package com.my.blog.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

    /**
     * 主题类型，0游客发表，1用户发表
     */
    private Integer type;

    /**
     * 评论账号
     */
    private String account;

    /**
     * 评论用户id
     */
    private Integer userId;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;
}