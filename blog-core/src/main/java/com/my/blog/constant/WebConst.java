package com.my.blog.constant;

public class WebConst {
    /**
     * 手机号正则
     */
    public static String MOBILE_PATTERN ="^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";
    /**
     * 密码正则
     */
    public static String PASSWORD_PATTERN ="^\\d{6,20}$";


    /**
     * 生成token基本信息
     */
    public static final String JWT_TOKEN_HEADER = "Authorization";
    public static final String JWT_HEADER_PREFIX = "Bearer ";
    public static final String JWT_SECRET = "iPanE1pA2sWo2dByZL";
    public static final Long JWT_EXPIRATION = 60 * 60 * 24 * 7L;
    /**
     * 管理员登录状态超时时间
     */
    public static final int MANAGER_LOGIN_ACTIVE_TIME_OUT = 10 * 60;

    /**
     * 登录用户类型
     */
    //管理员
    public static final Integer USER_TYPE_MANAGER = 1;
    //基本用户
    public static final Integer USER_TYPE_USER = 2;
}
