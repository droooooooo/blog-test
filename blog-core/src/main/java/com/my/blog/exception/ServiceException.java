package com.my.blog.exception;

import com.my.blog.constant.SysRetCodeEnum;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private String code;

    public ServiceException(String message, String code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    public ServiceException(SysRetCodeEnum sysRetCodeEnum){
        super(sysRetCodeEnum.getMessage());
        this.msg = sysRetCodeEnum.getMessage();
        this.code = sysRetCodeEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
