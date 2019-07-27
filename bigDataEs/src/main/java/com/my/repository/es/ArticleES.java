package com.my.repository.es;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "article", type = "doc")
public class ArticleES {
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
     * 浏览量
     */
    private Integer pv;

    /**
     * 文章类型0作者，1其他人,默认作者
     */
    private Integer articletype;

    /**
     * 文章状态0停用，1启用，默认启用
     */
    private Integer status;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    private Integer flag;
}