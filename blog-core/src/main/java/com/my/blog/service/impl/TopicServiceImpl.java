package com.my.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.my.blog.common.PageResultDTO;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.TopicMapper;
import com.my.blog.repository.dto.TopicDto;
import com.my.blog.repository.model.Topic;
import com.my.blog.repository.model.User;
import com.my.blog.service.TopicService;
import com.my.blog.util.PageResultUtil;
import com.my.blog.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserUtil userUtil;


    @Override
    public PageResultDTO<Topic> getArticleTopicList(Map<String, String> map) {
        String id = map.get("id");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        List<Topic> list = topicMapper.selectList(Integer.parseInt(id));
        return PageResultUtil.build(list);
    }


    @Override
    public void addTopic(TopicDto topicDto) {
        String token = userUtil.getToken();
        if (token == null && StringUtils.isEmpty(topicDto.getAccount())) {
            throw new ServiceException("请输入账号", "900001");
        }
        if (StringUtils.isEmpty(topicDto.getContent())) {
            throw new ServiceException("请输入留言内容", "900001");
        }

        if (token != null) {
            User user = userUtil.getUser(token);
            if (user == null) {
                topicDto.setUserId(user.getId());
            }
        } else {
            topicDto.setUserId(null);
        }
        int result = topicMapper.addTopic(topicDto);

        if (result < 1) {
            new ServiceException("新增留言失败", "900001");
        }
    }

    @Override
    public void deleteTopic(Integer id) {
        topicMapper.deleteById(id);
    }
}
