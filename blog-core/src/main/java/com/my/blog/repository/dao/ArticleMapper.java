package com.my.blog.repository.dao;

import com.my.blog.repository.dto.ArticleDto;
import com.my.blog.repository.model.Article;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends Mapper<Article> {

    List<Article> selectArticleList(Map map);

    Article queryOneById(@Param("id") Integer id);

    int insertOne(ArticleDto articleDto);

    int updateArticle(ArticleDto articleDto);

    int deleteById(@Param("id") Integer id);

    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}