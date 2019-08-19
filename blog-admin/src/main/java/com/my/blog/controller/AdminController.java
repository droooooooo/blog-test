package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.repository.dto.AdminDto;
import com.my.blog.repository.model.User;
import com.my.blog.repository.vo.AdminVo;
import com.my.blog.repository.vo.UserVo;
import com.my.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆controller
 */
@Slf4j
@RestController
@RequestMapping("logon")
public class AdminController {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ResponseView
    public AdminVo login(@RequestBody AdminDto adminDto){
        return adminService.login(adminDto);
    }

    @PostMapping("/register")
    @ResponseView
    public void register(@RequestBody AdminDto adminDto){
        adminService.register(adminDto);
    }

    @GetMapping("/verify")
    @ResponseView
    public UserVo verify(String account){
        return adminService.verify(account);
    }

    @PostMapping("/forget")
    @ResponseView
    public void forget(@RequestBody AdminDto adminDto){
        adminService.forget(adminDto);
    }
}
