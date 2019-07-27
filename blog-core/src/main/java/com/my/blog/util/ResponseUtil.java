package com.my.blog.util;

import com.my.blog.common.RestResponse;

public class ResponseUtil {
    public static RestResponse error(String message,String code){
        RestResponse result= new RestResponse();
        result.setReturnMsg(message);
        result.setCode(code);
        return result;
    }

    public static <T> RestResponse error(String message,String code,T data){
        RestResponse result= new RestResponse();
        result.setReturnMsg(message);
        result.setCode(code);
        result.setResult(data);
        return result;
    }
}
