package com.my.blog.util;

import com.my.blog.common.RestResponse;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class WebUtil {

    public static  void  sendJsonResponse(ServletResponse res, RestResponse retObject) throws IOException {
        res.setContentType("application/json;charset=utf-8");
        res.getWriter().write(JsonUtils.toJSONString(retObject));
    }
}
