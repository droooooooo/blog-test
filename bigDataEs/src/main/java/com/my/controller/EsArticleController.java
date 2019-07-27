package com.my.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.repository.dto.ArticleEsDto;
import com.my.repository.es.ArticleES;
import com.my.service.EsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class EsArticleController {

    @Autowired
    private EsArticleService esArticleService;

    @PostMapping("/esSearch")
    @ResponseView
    public PageResultDTO<ArticleES> esSearch(@RequestBody ArticleEsDto articleEsDto){
        return esArticleService.esSearch(articleEsDto);
    }

}
