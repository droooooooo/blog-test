package com.my.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEsDto {
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
    private Integer type;

    /**
     * 文章状态0停用，1启用，默认启用
     */
    private Integer status;

    /**
     * 文章内容
     */
    private String content;

    private Integer pageSize;

    private Integer pageNum;
}
