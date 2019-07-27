package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.RoleDto;
import com.my.blog.repository.vo.ResourceVo;
import com.my.blog.repository.vo.RoleVo;
import com.my.blog.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登陆controller
 */
@Slf4j
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/getRoles")
    @ResponseView
    public PageResultDTO<RoleVo> getRoles(@RequestBody Map<String,String> map){
        return roleService.getRoles(map);
    }


    @PostMapping("/add")
    @ResponseView
    public void getResourceList(@RequestBody RoleDto roleDto){
        roleService.add(roleDto);
    }

    @GetMapping("/getRoleById/{id}")
    @ResponseView
    public RoleVo getResourceById(@PathVariable("id") Integer id){
        return roleService.getRoleById(id);
    }

    @GetMapping("/removeOne/{id}")
    @ResponseView
    public void removeOne(@PathVariable("id") Integer id){
        roleService.removeOne(id);
    }

    @PostMapping("/update")
    @ResponseView
    public void update(@RequestBody RoleDto roleDto){
        roleService.update(roleDto);
    }
}
