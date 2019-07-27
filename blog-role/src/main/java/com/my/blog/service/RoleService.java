package com.my.blog.service;


import com.my.blog.common.PageResultDTO;
import com.my.blog.repository.dto.RoleDto;
import com.my.blog.repository.model.Role;
import com.my.blog.repository.vo.RoleVo;

import java.util.Map;

public interface RoleService {

    /**
     * 获取角色列表
     * @param map
     * @return
     */
    public PageResultDTO<RoleVo> getRoles(Map<String,String> map);

    /**
     * 根据id获取资源
     * @param id
     * @return
     */
    RoleVo getRoleById(Integer id);

    /**
     * 添加资源
     * @param roleDto
     */
    void add(RoleDto roleDto);

    /**
     * 删除资源
     * @param id
     */
    void removeOne(Integer id);

    /**
     * 更新资源
     * @param roleDto
     */
    void update(RoleDto roleDto);
}
