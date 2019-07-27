package com.my.service.impl;


import com.my.blog.common.PageResultDTO;
import com.my.blog.util.PageResultUtil;
import com.my.repository.dto.ArticleEsDto;
import com.my.repository.es.ArticleES;
import com.my.repository.es.ArticleRepository;
import com.my.service.EsArticleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EsArticleServiceImpl implements EsArticleService {

    @Autowired
    @Qualifier("articleRepository")
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 获取列表
     *
     * @param articleEsDto
     * @return
     */
    @Override
    /**
     * es搜索
     */
    public PageResultDTO<ArticleES> esSearch(ArticleEsDto articleEsDto) {
        Integer pageNum = articleEsDto.getPageNum();
        Integer pageSize = articleEsDto.getPageSize();
        String articleName = articleEsDto.getTitle();
        String articleContent = articleEsDto.getContent();
        String author = articleEsDto.getAuthor();
        String description = articleEsDto.getDescription();

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        //根据id查询
        if (articleEsDto.getId() != null) {
            queryBuilder.must(QueryBuilders.termQuery("id", articleEsDto.getId()));
        }
        //根据状态查询
        if (articleEsDto.getStatus() != null) {
            queryBuilder.must(QueryBuilders.termQuery("status", articleEsDto.getStatus()));
        }
        //根据标题查询
        if (StringUtils.isNotEmpty(articleName)) {
            queryBuilder.must(QueryBuilders.termQuery("article_name.keyword", articleName));
        }
        //根据内容模糊查询
        if (StringUtils.isNotEmpty(articleContent)) {
            queryBuilder.must(QueryBuilders.matchQuery("article_content", articleContent));
        }
        //根据作者查询
        if (StringUtils.isNotEmpty(author)) {
            queryBuilder.must(QueryBuilders.termQuery("article_author.keyword", author));
        }
        //根据描述模糊查询
        if (StringUtils.isNotEmpty(description)) {
            queryBuilder.must(QueryBuilders.matchQuery("article_description", description));
        }

        //按照博客的评论数的排序是依次降低
        FieldSortBuilder sort = SortBuilders.fieldSort("id").order(SortOrder.DESC);

        //设置分页(从第一页开始，一页显示10条)
        //注意开始是从0开始，有点类似sql中的方法limit 的查询
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);

        //2.构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中 分页设置到构建中 排序设置到构建中 生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder
                .withQuery(queryBuilder)
                .withPageable(pageRequest)
                .withSort(sort)
                .build();

        //3.执行方法1
        Page<ArticleES> page = articleRepository.search(query);
        //执行方法2：注意，这儿执行的时候还有个方法那就是使用elasticsearchTemplate
        List<ArticleES> list = elasticsearchTemplate.queryForList(query, ArticleES.class);

        return PageResultUtil.build(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements());
    }

//    @Override
//    public void updateStatus(ArticleDto articleDto) {
//        int status = articleDto.getStatus();
//        int id = articleDto.getId();
//
//        int result = articleMapper.updateStatus(id, status);
//        if (result < 1) {
//            throw new ServiceException(SysRetCodeEnum.USER_STATUS_ERROR);
//        }
//
////        ArticleES articleES = new ArticleES();
////        Article article = getById(id);
////        articleES.setId(article.getId());
////        articleES.setTitle(article.getArticleName());
////        articleES.setAuthor(article.getArticleAuthor());
////        articleES.setDescription(article.getArticleDescription());
////        articleES.setContent(article.getArticleContent());
////        articleES.setCreatetime(article.getCreateTime());
////        articleES.setUpdatetime(article.getUpdateTime());
////        articleES.setPv(article.getArticlePv());
////        articleES.setArticletype(article.getArticleType());
////        articleES.setStatus(article.getStatus());
////
////        UpdateQuery updateQuery = new UpdateQuery();
////        updateQuery.setId(String.valueOf(id));
////        updateQuery.setClazz(ArticleES.class);
////        UpdateRequest request = new UpdateRequest();
////
////        String json = JsonUtils.toJSONString(articleES);
////        Map<String, Object> map = new HashMap();
////        map = new com.google.gson.Gson().fromJson(json,map.getClass());
////        map.put("createtime", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(article.getCreateTime()));
////        map.put("updatetime",new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(article.getUpdateTime()));
////        request.doc(map);
////        request.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
////        updateQuery.setUpdateRequest(request);
////        elasticsearchTemplate.update(updateQuery);
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
}
