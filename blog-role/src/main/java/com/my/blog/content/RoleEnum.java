package com.my.blog.content;

public enum RoleEnum {

    ADMINISTRATOR(1);

    private int code;

    RoleEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
