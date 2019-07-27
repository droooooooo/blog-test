package com.my.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.my.blog.common.PageResultDTO;
import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.ResourceMapper;
import com.my.blog.repository.dto.ResourceDto;
import com.my.blog.repository.model.Resource;
import com.my.blog.repository.vo.ResourceVo;
import com.my.blog.service.ResourceService;
import com.my.blog.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 获取资源列表
     *
     * @param map
     * @return
     */
    @Override
    public PageResultDTO<ResourceVo> getResource(Map<String, String> map) {
        Integer pageNum = Integer.parseInt(map.get("pageNum"));
        Integer pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<ResourceVo> list = resourceMapper.getResource(map);
        return PageResultUtil.build(list);
    }

    @Override
    public ResourceVo getResourceById(Integer id) {
        return resourceMapper.getResourceById(id);
    }

    @Override
    public void add(ResourceDto resourceDto) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDto, resource);
        int result = resourceMapper.insertOne(resource);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_ADD_ERROR);
        }
    }

    @Override
    public void removeOne(Integer id) {
        int result = resourceMapper.removeOne(id);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_DELETE_ERROR);
        }
    }

    @Override
    public void update(ResourceDto resourceDto) {
        if (resourceDto.getId() == null) {
            throw new ServiceException(SysRetCodeEnum.ROLE_UPDATE_ERROR);
        }
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceDto, resource);
        int result = resourceMapper.updateOne(resource);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_UPDATE_ERROR);
        }
        resourceMapper.updateOne(resource);
    }
}
