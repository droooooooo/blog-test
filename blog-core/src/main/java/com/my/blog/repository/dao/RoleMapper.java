package com.my.blog.repository.dao;

import com.my.blog.repository.model.Role;
import com.my.blog.repository.vo.RoleVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {

    List<RoleVo> getRoles(Map map);

    RoleVo getRoleById(Integer id);

    int insertOne(Role resource);

    int removeOne(Integer id);

    int updateOne(Role resource);
}
