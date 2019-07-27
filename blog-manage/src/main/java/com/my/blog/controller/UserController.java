package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.UserDto;
import com.my.blog.repository.model.User;
import com.my.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户
 */
@RestController
@RequestMapping("manageUser")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getList")
    @ResponseView
    public PageResultDTO<User> getList(@RequestBody Map<String, String> map) {
        return userService.getList(map);
    }

    @GetMapping("/getUserById")
    @ResponseView
    public User getById(Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/deleteById")
    @ResponseView
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }

    @PostMapping("/updateUserInfo")
    @ResponseView
    public User updateUserInfo(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @PostMapping("/updateStatus")
    @ResponseView
    public void updateStatus(@RequestBody UserDto userDto) {
        userService.updateStatus(userDto);
    }
}
