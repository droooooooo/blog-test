package com.my.blog.controller;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.ResourceDto;
import com.my.blog.repository.vo.ResourceVo;
import com.my.blog.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登陆controller
 */
@Slf4j
@RestController
@RequestMapping("role/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/getResourceList")
    @ResponseView
    public PageResultDTO<ResourceVo> getResourceList(@RequestBody Map<String,String> map){
        return resourceService.getResource(map);
    }

    @PostMapping("/add")
    @ResponseView
    public void getResourceList(@RequestBody ResourceDto resourceDto){
        resourceService.add(resourceDto);
    }

    @GetMapping("/getResourceById/{id}")
    @ResponseView
    public ResourceVo getResourceById(@PathVariable("id") Integer id){
        return resourceService.getResourceById(id);
    }

    @GetMapping("/removeOne/{id}")
    @ResponseView
    public void removeOne(@PathVariable("id") Integer id){
        resourceService.removeOne(id);
    }

    @PostMapping("/update")
    @ResponseView
    public void update(@RequestBody ResourceDto resourceDto){
        resourceService.update(resourceDto);
    }
}
