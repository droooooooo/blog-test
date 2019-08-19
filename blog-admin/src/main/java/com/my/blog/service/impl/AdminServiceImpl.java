package com.my.blog.service.impl;

import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.constant.WebConst;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.dao.UserMapper;
import com.my.blog.repository.dto.AdminDto;
import com.my.blog.repository.model.Admin;
import com.my.blog.repository.model.User;
import com.my.blog.repository.vo.AdminVo;
import com.my.blog.repository.vo.UserVo;
import com.my.blog.service.AdminService;
import com.my.blog.util.JsonUtils;
import com.my.blog.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
    public void register(AdminDto adminDto) {
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
            User user = new User();
            user.setUserName(adminDto.getAccount());
            user.setUserPassword(adminDto.getPassword());
            result = userMapper.insertOne(user);
        } catch (Exception e) {
            log.info(JsonUtils.toJSONString(e));
            throw new ServiceException(SysRetCodeEnum.USER_REGISTER_ERROR);
        }

        if (result < 1) {
            throw new ServiceException(SysRetCodeEnum.USER_REGISTER_ERROR);
        }
    }

    @Override
    public UserVo verify(String account) {
        if (account == null || !Pattern.matches(WebConst.MOBILE_PATTERN, account)) {
            throw new ServiceException(SysRetCodeEnum.ACCOUNT_ENTER_ERROR);
        }

        User user = userMapper.selectByAccount(account);
        if (user == null) {
            throw new ServiceException(SysRetCodeEnum.VALID_USER_EMPTY);
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

    @Override
    public void forget(AdminDto adminDto) {
        checkParams(adminDto);

        try {
            User user = userMapper.selectByAccount(adminDto.getAccount());
            if (user == null) {
                throw new ServiceException(SysRetCodeEnum.VALID_USER_EMPTY);
            }

            if (user.getUserPassword().equals(adminDto.getPassword())) {
                throw new ServiceException(SysRetCodeEnum.PASSWORD_UPDATE_SAME_ERROR);
            }

            Map map = new HashMap<>();
            map.put("id", user.getId());
            map.put("account", user.getUserName());
            map.put("password", adminDto.getPassword());
            int result = userMapper.update(map);
            if (result < 1) {
                throw new ServiceException(SysRetCodeEnum.PASSWORD_UPDATE_ERROR);
            }
        } catch (ServiceException e) {
            throw e;
        }catch (Exception e){
            throw new ServiceException(SysRetCodeEnum.PASSWORD_UPDATE_ERROR);
        }
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
