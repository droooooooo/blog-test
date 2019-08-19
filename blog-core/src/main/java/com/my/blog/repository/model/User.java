package com.my.blog.repository.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user")
public class User {
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     *设置用户密码
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 获取昵称
     *
     * @return user_nikename - 昵称
     */
    public String getUserNikename() {
        return userNikename;
    }

    /**
     * 设置昵称
     *
     * @param userNikename 昵称
     */
    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename == null ? null : userNikename.trim();
    }

    /**
     * 获取手机号码
     *
     * @return user_telephone - 手机号码
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     * 设置手机号码
     *
     * @param userTelephone 手机号码
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone == null ? null : userTelephone.trim();
    }

    /**
     * 获取用户类型 0管理员,1用户
     *
     * @return user_type - 用户类型 0管理员,1用户
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型 0管理员,1用户
     *
     * @param userType 用户类型 0管理员,1用户
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取用户状态0停用，1启用，默认启用
     *
     * @return status - 用户状态0停用，1启用，默认启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态0停用，1启用，默认启用
     *
     * @param status 用户状态0停用，1启用，默认启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}