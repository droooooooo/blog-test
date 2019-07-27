package com.my.blog.util;

import com.alibaba.druid.util.StringUtils;
import com.my.blog.exception.ServiceException;
import com.my.blog.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {

    private JwtUtil jwtUtil;

    @Autowired
    private RedisUtil redisUtil;

       public User getUser(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new ServiceException("没有此用户", "100001");
        }

        //解密token，拿到里面的对象claims
        return jwtUtil.getUser(token);
    }

    public String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String token = request.getParameter("token");
        HttpServletRequest rq = (HttpServletRequest) request;

        if (StringUtils.isEmpty(token)) {
            token = rq.getHeader("token");
        }
        return token;
    }
}
