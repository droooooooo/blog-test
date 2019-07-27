package com.my.blog.repository.dao;

import com.my.blog.repository.model.Resource;
import com.my.blog.repository.vo.ResourceVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ResourceMapper extends Mapper<Resource> {

    List<ResourceVo> getResource(Map map);

    ResourceVo getResourceById(Integer id);

    int insertOne(Resource resource);

    int removeOne(Integer id);

    int updateOne(Resource resource);

}
