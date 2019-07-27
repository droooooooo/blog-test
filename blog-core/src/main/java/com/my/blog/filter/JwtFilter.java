package com.my.blog.filter;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;
import com.my.blog.constant.SysRetCodeEnum;
import com.my.blog.repository.model.User;
import com.my.blog.util.JwtUtil;
import com.my.blog.util.RedisUtil;
import com.my.blog.util.ResponseUtil;
import com.my.blog.util.WebUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JwtFilter implements Filter {
    public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
    protected PatternMatcher pathMatcher = new ServletPathMatcher();
    private Set<String> excludesPattern;
    private String contextPath;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("exclusions");

        if (param != null && param.trim().length() != 0) {
            this.excludesPattern = new HashSet(Arrays.asList(param.split("\\s*,\\s*")));
        }

        contextPath = filterConfig.getServletContext().getContextPath();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        // 过滤器只处理 GET POST 请求
        if (!"GET".equalsIgnoreCase(httpRequest.getMethod()) && !"POST".equals(httpRequest.getMethod())) {
            chain.doFilter(req, res);
            return;
        }

        //排除不检查的url
        if (isExclusion(httpRequest.getRequestURI())) {
            chain.doFilter(req, res);
            return;
        }

        //客户端将token封装在请求头中，格式为（Bearer后加空格）：Authorization：Bearer +token
        final String token = getSessionId(req, res);
        if (StringUtils.isEmpty(token)) {
            sendErrorResponse(res);
            return;
        }

        try {
            //根据token验证用户
            boolean hasUser = jwtUtil.verify(token);
            if (!hasUser) {
                sendErrorResponse(res);
                return;
            }
        } catch (ExpiredJwtException | MalformedJwtException e) {
            sendErrorResponse(res);
            return;
        }

        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {

    }

    /**
     * 获取请求sessionId
     *
     * @param request
     * @param response
     * @return
     */
    private String getSessionId(ServletRequest request, ServletResponse response) {
        String token = request.getParameter("token");
        HttpServletRequest rq = (HttpServletRequest) request;

        if (StringUtils.isEmpty(token)) {
            token = rq.getHeader("token");
        }
        return token;
    }

    public boolean isExclusion(String requestURI) {

        if (this.excludesPattern == null || requestURI == null) {
            return false;
        }

        if (requestURI.startsWith(this.contextPath)) {
            requestURI = requestURI.substring(this.contextPath.length());
            if (!requestURI.startsWith("/")) {
                requestURI = "/" + requestURI;
            }
        }

        Iterator var2 = this.excludesPattern.iterator();

        String pattern;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            pattern = (String) var2.next();
        } while (!this.pathMatcher.matches(pattern, requestURI));

        return true;

    }

    private void sendErrorResponse(ServletResponse res) throws IOException {
        WebUtil.sendJsonResponse(res, ResponseUtil.error(SysRetCodeEnum.USER_AUTH_ERROR.getMessage(), SysRetCodeEnum.USER_AUTH_ERROR.getCode(), ""));
    }
}
