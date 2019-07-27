package com.my.blog.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @SequenceGenerator(name = "", sequenceName = "SELECT LAST_INSERT_ID()")
    private Integer id;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 昵称
     */
    private String userNikename;

    /**
     * 手机号码
     */
    private String userTelephone;

    /**
     * 用户类型 0管理员,1用户
     */
    private Integer userType;

    /**
     * 用户状态0停用，1启用，默认启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer flag;
}
