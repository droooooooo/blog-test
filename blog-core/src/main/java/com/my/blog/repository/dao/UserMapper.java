package com.my.blog.repository.dao;

import com.my.blog.repository.dto.AdminDto;
import com.my.blog.repository.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {
    List<User> selectUserList(Map map);

    User selectByAccount(@Param("account") String account);

    User selectByParams(AdminDto adminDto);

    User selectById(@Param("id") Integer id);

    int insertOne(User user);

    int update(Map map);

    int updateStatus(Map map);

    int deleteById(@Param("id") Integer id);
}