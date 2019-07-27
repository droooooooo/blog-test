package com.my.blog.service;


import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.ResourceDto;
import com.my.blog.repository.vo.ResourceVo;

import java.util.Map;

public interface ResourceService {

    /**
     * 获取资源列表
     * @param map
     * @return
     */
    PageResultDTO<ResourceVo> getResource(Map<String, String> map);

    /**
     * 根据id获取资源
     * @param id
     * @return
     */
    ResourceVo getResourceById(Integer id);

    /**
     * 添加资源
     * @param resourceDto
     */
    void add(ResourceDto resourceDto);

    /**
     * 删除资源
     * @param id
     */
    void removeOne(Integer id);

    /**
     * 更新资源
     * @param resourceDto
     */
    void update(ResourceDto resourceDto);
}
