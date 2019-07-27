package com.my.repository.es;



import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ArticleRepository extends ElasticsearchRepository<ArticleES, String> {
}
