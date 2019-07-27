package com.my.blog.repository.dao;

import com.my.blog.repository.dto.TopicDto;
import com.my.blog.repository.model.Topic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TopicMapper extends Mapper<Topic> {

    List<Topic> selectList(@Param("id") Integer id);

    int addTopic(TopicDto topicDto);

    int deleteById(Integer id);
}