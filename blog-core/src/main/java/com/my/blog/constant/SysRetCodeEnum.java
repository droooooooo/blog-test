package com.my.blog.constant;

public enum SysRetCodeEnum{

    COM_SUCCESS("0000", "调用成功"),
    COM_FAIL("9999", "调用失败"),

    SysError("900001","系统异常"),
    ControllerError("80001","controller异常"),
    USER_AUTH_ERROR("80002","认证失敗"),

    //返回码类型--通用-用户(2开头)
    VALID_USER_EMPTY("20001","用户不存在,或已停用"),
    ACCOUNT_ENTER_ERROR("20002","账号格式错误"),
    PASSWORD_ENTER_ERROR("20003","密码格式错误"),
    USER_ALREADEY_ERROR("20004","用户已存在"),
    USER_REGISTER_ERROR("20005","注册失败"),
    USER_LOGIN_ERROR("20006","用户名或密码错误"),
    USER_UPDATE_ERROR("20007","用户更新错误"),
    USER_DELETE_ERROR("20008","用户删除失败"),
    USER_STATUS_ERROR("20009","用户更新状态失败"),
    PASSWORD_UPDATE_ERROR("20010","密码更新失败"),
    PASSWORD_UPDATE_SAME_ERROR("20010","输入的密码与原密码相同"),

    //返回码类型--通用-文章(3开头)
    VALID_ARTICLE_EMPTY("30001","文章不存在"),
    ARTICLE_ADD_ERROR("30002","文章新增失败"),
    ARTICLE_DELETE_ERROR("30003","文章删除失败"),
    ARTICLE_UPDATE_ERROR("30007","文章更新错误"),

    //返回码类型--通用-权限(4开头)
    VALID_ROLE_EMPTY("40001","权限不存在"),
    ROLE_ADD_ERROR("40002","权限新增失败"),
    ROLE_DELETE_ERROR("40003","权限删除失败"),
    ROLE_UPDATE_ERROR("40007","权限更新错误"),
    ROLE_ADMIN_UPDATE_ERROR("40008","不能更新超级管理员");

    private String code;

    private String message;

    SysRetCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
