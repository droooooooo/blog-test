package com.my.blog.service;

import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.TopicDto;
import com.my.blog.repository.model.Topic;

import java.util.Map;

public interface TopicService {
    /**
     * 获取文章留言
     * @param map
     * @return
     */
    PageResultDTO<Topic> getArticleTopicList(Map<String,String> map);
    /**
     * 新增留言
     * @param topicDto
     */
    void addTopic(TopicDto topicDto);

    /**
     * 删除留言
     * @param id
     */
    void deleteTopic(Integer id);


}
