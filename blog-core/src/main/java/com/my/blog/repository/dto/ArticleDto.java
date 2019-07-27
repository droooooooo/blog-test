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
public class ArticleDto {
    @Id
    @SequenceGenerator(name="",sequenceName="SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 文章类型0作者，1其他人,默认作者
     */
    private Integer type;

    /**
     * 文章状态0停用，1启用，默认启用
     */
    private Integer status;

    private Integer flag;

    /**
     * 文章内容
     */
    private String content;

    private Integer pv;

    /**
     * 创建时间
     */
    private Date createTime;
}