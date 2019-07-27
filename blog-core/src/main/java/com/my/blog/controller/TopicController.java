package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.TopicDto;
import com.my.blog.repository.model.Topic;
import com.my.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping("/getList")
    @ResponseView
    public PageResultDTO<Topic> getArticleTopicList(@RequestBody Map<String,String> map){
        return topicService.getArticleTopicList(map);
    }


    @PostMapping("/addTopic")
    @ResponseView
    public void addTopic(@RequestBody TopicDto topicDto){
        topicService.addTopic(topicDto);
    }

    @GetMapping("/deleteById")
    @ResponseView
    public void deleteById(Integer id){
        topicService.deleteTopic(id);
    }
}
