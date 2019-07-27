package com.my.blog.exception;

import com.alibaba.druid.support.json.JSONUtils;
import com.my.blog.annotation.ResponseView;
import com.my.blog.common.RestResponse;
import com.my.blog.util.JsonUtils;
import com.my.blog.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorActionAdvice {

    /**
     * @return
     * @Title: error
     * @Description: 异常处理
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseView
    public RestResponse handleFinalException(ServiceException e) {
        log.info(JsonUtils.toJSONString(e));
        return ResponseUtil.error(e.getMessage(), e.getCode(),"");
    }

    /**
     * @return
     * @Title: error
     * @Description: 异常处理
     */
    @ExceptionHandler(SystemException.class)
    @ResponseView
    public RestResponse handleSystemException(SystemException e) {
        log.info(JsonUtils.toJSONString(e));
        return ResponseUtil.error(e.getMessage(), e.getCode(),"");
    }
}
