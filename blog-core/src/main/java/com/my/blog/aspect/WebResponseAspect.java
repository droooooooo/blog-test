package com.my.blog.aspect;

import com.my.blog.annotation.ResponseView;
import com.my.blog.common.RestResponse;
import com.my.blog.util.JsonUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class WebResponseAspect implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //设置自定义成功信息
        ResponseView viewAnnotation = returnType.getMethodAnnotation(ResponseView.class);

        //如果不是responseView直接返回
        if (viewAnnotation == null) {
            return o;
        }

        if (o instanceof RestResponse) {
            return o;
        }

        RestResponse result = new RestResponse();
        result.setData(o);
        result.setSuccess(true);
        String successMsg = viewAnnotation.successMsg();
        if (StringUtils.isNotEmpty(successMsg)) {
            result.setReturnMsg(successMsg);
        }
        return result;
    }

}
