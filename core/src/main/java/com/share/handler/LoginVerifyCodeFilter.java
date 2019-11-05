package com.share.handler;

import com.share.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginVerifyCodeFilter extends GenericFilterBean {

    @Autowired
    private RedisService redisService;

    private String defaultFilterProcessUrl = "/api/login";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getMethod().equalsIgnoreCase("POST") && req.getServletPath().equalsIgnoreCase(defaultFilterProcessUrl)) {
            String verifyCode = request.getParameter("verify_code");
            String redisVerifyCode = (String) redisService.get(request.getRemoteAddr());
            if (StringUtils.isEmpty(verifyCode) && StringUtils.isEmpty(redisVerifyCode)) {
                chain.doFilter(request, response);
                return;
            }

            if (!verifyCode.equalsIgnoreCase((String) redisService.get(request.getLocalAddr()))) {
                response.getWriter().println("{\"code\":\"-1\",\"message\": \" Please input the verify code. \"}");
                return;
            }
        }

        chain.doFilter(request, response);
        return;
    }
}
