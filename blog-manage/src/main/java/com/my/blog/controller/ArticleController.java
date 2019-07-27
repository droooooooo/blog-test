package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.ArticleDto;
import com.my.blog.repository.model.Article;
import com.my.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 文章
 */
@RestController
@RequestMapping("manageArticle")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/getList")
    @ResponseView
    public PageResultDTO<Article> getList(@RequestBody Map<String,String> map){
        return articleService.getList(map);
    }

    @GetMapping("/getArticleById/{id}")
    @ResponseView
    public Article getById(@PathVariable("id") Integer id){
        return articleService.getById(id);
    }


    @PostMapping("/add")
    @ResponseView
    public void addUser(@RequestBody ArticleDto articleDto){
       articleService.addArticle(articleDto);
    }

    @GetMapping("/deleteById")
    @ResponseView
    public void deleteById(Integer id){
        articleService.deleteById(id);
    }

    @PostMapping("/update")
    @ResponseView
    public Article updateArticle(@RequestBody ArticleDto articleDto){
        return articleService.updateArticle(articleDto);
    }

    @PostMapping("/updateStatus")
    @ResponseView
    public void updateStatus(@RequestBody ArticleDto articleDto){
        articleService.updateStatus(articleDto);
    }
}
