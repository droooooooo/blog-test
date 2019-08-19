package com.my.blog.service;

import com.my.blog.repository.dto.AdminDto;
import com.my.blog.repository.model.Admin;
import com.my.blog.repository.model.User;
import com.my.blog.repository.vo.AdminVo;
import com.my.blog.repository.vo.UserVo;

public interface AdminService {

    /**
     * 登陆
     * @return
     */
    AdminVo login(AdminDto adminDto);

    /**
     * 注册
     * @return
     */
    void register(AdminDto adminDto);

    /**
     * 验证用户
     * @param account
     * @return
     */
    UserVo verify(String account);

    /**
     * 登出
     */
    void logout(Admin admin);

    /**
     * 更新
     * @return
     */
    void forget(AdminDto adminDto);
}
