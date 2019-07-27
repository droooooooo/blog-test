package com.my.blog.service.impl;


import com.github.pagehelper.PageHelper;
import com.my.blog.common.PageResultDTO;
import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.ArticleMapper;
import com.my.blog.repository.dto.ArticleDto;
import com.my.blog.repository.model.Article;
import com.my.blog.service.ArticleService;
import com.my.blog.util.PageResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    /**
     * 获取列表
     *
     * @param map
     * @return
     */
    @Override
    public PageResultDTO<Article> getList(Map<String, String> map) {
        Integer pageNum = Integer.parseInt(map.get("pageNum"));
        Integer pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectArticleList(map);
        return PageResultUtil.build(list);
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @Override
    public Article getById(Integer id) {
        return articleMapper.queryOneById(id);
    }

    @Override
    public Article updateArticle(ArticleDto articleDto) {
        int id = articleDto.getId();

        Article find = getById(id);

        if (find == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_ARTICLE_EMPTY);
        }

        int result = articleMapper.updateArticle(articleDto);

        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ARTICLE_UPDATE_ERROR);
        }
        return getById(articleDto.getId());
    }

    @Override
    public void deleteById(Integer id) {
        Article article = getById(id);
        if (article == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_ARTICLE_EMPTY);
        }
        int result = articleMapper.deleteById(id);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ARTICLE_DELETE_ERROR);
        }
    }

    @Override
    public void addArticle(ArticleDto articleDto) {
        int result = articleMapper.insertOne(articleDto);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ARTICLE_ADD_ERROR);
        }
    }

    @Override
    public void updateStatus(ArticleDto articleDto) {
        int status = articleDto.getStatus();
        int id = articleDto.getId();

        int result = articleMapper.updateStatus(id, status);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_STATUS_ERROR);
        }

//        ArticleES articleES = new ArticleES();
//        Article article = getById(id);
//        articleES.setId(article.getId());
//        articleES.setTitle(article.getArticleName());
//        articleES.setAuthor(article.getArticleAuthor());
//        articleES.setDescription(article.getArticleDescription());
//        articleES.setContent(article.getArticleContent());
//        articleES.setCreatetime(article.getCreateTime());
//        articleES.setUpdatetime(article.getUpdateTime());
//        articleES.setPv(article.getArticlePv());
//        articleES.setArticletype(article.getArticleType());
//        articleES.setStatus(article.getStatus());
//
//        UpdateQuery updateQuery = new UpdateQuery();
//        updateQuery.setId(String.valueOf(id));
//        updateQuery.setClazz(ArticleES.class);
//        UpdateRequest request = new UpdateRequest();
//
//        String json = JsonUtils.toJSONString(articleES);
//        Map<String, Object> map = new HashMap();
//        map = new com.google.gson.Gson().fromJson(json,map.getClass());
//        map.put("createtime", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(article.getCreateTime()));
//        map.put("updatetime",new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(article.getUpdateTime()));
//        request.doc(map);
//        request.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
//        updateQuery.setUpdateRequest(request);
//        elasticsearchTemplate.update(updateQuery);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
