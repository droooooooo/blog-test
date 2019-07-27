package com.my.service;


import com.my.blog.common.PageResultDTO;
import com.my.repository.dto.ArticleEsDto;
import com.my.repository.es.ArticleES;

public interface EsArticleService {
    /**
     * 获取文章列表
     */
    PageResultDTO<ArticleES> esSearch(ArticleEsDto articleEsDto);

}
