package com.my.blog.service;

import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.UserDto;
import com.my.blog.repository.model.User;

import java.util.Map;

public interface UserService {
    /**
     * 获取用户列表
     */
    PageResultDTO<User> getList(Map<String, String> map);

    User getById(Integer id);

    User updateUser(UserDto userDto);

    void deleteById(Integer id);

    void updateStatus(UserDto userDto);
}
