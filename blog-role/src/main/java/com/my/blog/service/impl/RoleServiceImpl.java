package com.my.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.my.blog.common.PageResultDTO;
import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.content.RoleEnum;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.RoleMapper;
import com.my.blog.repository.dto.RoleDto;
import com.my.blog.repository.model.Role;
import com.my.blog.repository.vo.RoleVo;
import com.my.blog.service.RoleService;
import com.my.blog.util.PageResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取角色列表
     *
     * @param map
     * @return
     */
    @Override
    public PageResultDTO<RoleVo> getRoles(Map<String, String> map) {
        Integer pageNum = Integer.parseInt(map.get("pageNum"));
        Integer pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<RoleVo> list = roleMapper.getRoles(map);
        return PageResultUtil.build(list);
    }

    @Override
    public RoleVo getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public void add(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        int result = roleMapper.insertOne(role);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_ADD_ERROR);
        }
    }

    @Override
    public void removeOne(Integer id) {
        int result = roleMapper.removeOne(id);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_DELETE_ERROR);
        }
    }

    @Override
    public void update(RoleDto roleDto) {
        this.checkAdministrator(roleDto);

        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        int result = roleMapper.updateOne(role);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.ROLE_UPDATE_ERROR);
        }
        roleMapper.updateOne(role);
    }

    private void checkAdministrator(RoleDto roleDto) {
        if(roleDto.getType()==null){
            throw new ServiceException(SysRetCodeEnum.ROLE_UPDATE_ERROR);
        }
        if (roleDto.getType().intValue() == RoleEnum.ADMINISTRATOR.getCode()) {
            throw new ServiceException(SysRetCodeEnum.ROLE_ADMIN_UPDATE_ERROR);
        }
    }

}
