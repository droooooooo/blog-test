package com.my.blog.service;

import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.ArticleDto;
import com.my.blog.repository.model.Article;

import java.util.Map;

public interface ArticleService {
    /**
     * 获取文章列表
     */
    PageResultDTO<Article> getList(Map<String, String> map);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Article getById(Integer id);

    /**
     * 更新文章
     * @param articleDto
     * @return
     */
    Article updateArticle(ArticleDto articleDto);

    /**
     * 删除文章
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增文章
     * @param articleDto
     */
    void addArticle(ArticleDto articleDto);

    /**
     * 更新文章状态
     * @param articleDto
     */
    void updateStatus(ArticleDto articleDto);
}
