package com.my.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.my.blog.common.PageResultDTO;
import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.UserMapper;
import com.my.blog.repository.dto.UserDto;
import com.my.blog.repository.model.User;
import com.my.blog.service.UserService;
import com.my.blog.util.PageResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户列表
     *
     * @param map
     * @return
     */
    @Override
    public PageResultDTO<User> getList(Map<String, String> map) {
        Integer pageNum = Integer.parseInt(map.get("pageNum"));
        Integer pageSize = Integer.parseInt(map.get("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectUserList(map);
        return PageResultUtil.build(list);
    }

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User updateUser(UserDto userDto) {
        int id = userDto.getId();

        User userVo = getById(id);
        if (userVo == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_USER_EMPTY);
        }

        Map map = new HashMap();
        map.put("id", userDto.getId());
        map.put("password", userDto.getPassword());
        map.put("nikename", userDto.getNikename());
        map.put("telephone", userDto.getTelephone());
        int result = userMapper.update(map);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_UPDATE_ERROR);
        }
        return getById(userDto.getId());
    }

    @Override
    public void deleteById(Integer id) {
        User userVo = getById(id);
        if (userVo == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_USER_EMPTY);
        }
        int result = userMapper.deleteById(id);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_DELETE_ERROR);
        }
    }

    @Override
    public void updateStatus(UserDto userDto) {
        int status = userDto.getStatus();
        int id = userDto.getId();
        Map map = new HashMap();
        map.put("id", id);
        map.put("status", status);
        int result = userMapper.updateStatus(map);
        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_STATUS_ERROR);
        }
    }
}
