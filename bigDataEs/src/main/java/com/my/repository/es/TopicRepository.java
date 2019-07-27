package com.my.repository.es;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TopicRepository extends ElasticsearchRepository<TopicES, String> {
}
