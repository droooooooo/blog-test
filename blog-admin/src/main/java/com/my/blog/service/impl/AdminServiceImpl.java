package com.my.blog.service.impl;

import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.constant.WebConst;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.UserMapper;
import com.my.blog.repository.dto.AdminDto;
import com.my.blog.repository.model.Admin;
import com.my.blog.repository.model.User;
import com.my.blog.repository.vo.AdminVo;
import com.my.blog.service.AdminService;
import com.my.blog.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
@Slf4j
/**
 * admin类
 * @author: zhenglijiang
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public AdminVo login(AdminDto adminDto) {
        checkParams(adminDto);
        User result = userMapper.selectByParams(adminDto);
        if (result == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_USER_EMPTY);
        }
        return jwtUtil.create(result);
    }

    @Override
    public User register(AdminDto adminDto) {
        checkParams(adminDto);
        String account = adminDto.getAccount();
        int result = 0;
        //检查用户是否存在
        User find = userMapper.selectByAccount(account);
        if (find != null) {
            throw new ServiceException(SysRetCodeEnum.USER_ALREADEY_ERROR);
        }
        //注册
        try {
            result = userMapper.insertOne(adminDto);
        } catch (Exception e) {
//            log.info(JsonUtils.toJSONString(e));
            throw new ServiceException(SysRetCodeEnum.USER_REGISTER_ERROR);
        }

        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_REGISTER_ERROR);
        }

        return userMapper.selectByAccount(account);
    }

    @Override
    public User verify(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public void logout(Admin admin) {

    }

    private void checkParams(AdminDto adminDto) {
        String account = adminDto.getAccount();
        String password = adminDto.getPassword();
        if (account == null || !Pattern.matches(WebConst.MOBILE_PATTERN, account)) {
            throw new ServiceException(SysRetCodeEnum.ACCOUNT_ENTER_ERROR);
        }

        if (password == null || !Pattern.matches(WebConst.PASSWORD_PATTERN, password)) {
            throw new ServiceException(SysRetCodeEnum.PASSWORD_ENTER_ERROR);
        }
    }
}
