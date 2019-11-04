package com.share.handler;

import com.share.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginVerifyCodeFilter extends OncePerRequestFilter {

    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = request.getSession().getServletContext();
        XmlWebApplicationContext xmlWebApplicationContext = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(servletContext);
        if (xmlWebApplicationContext != null && xmlWebApplicationContext.getBean("redisService") != null && redisService == null)
            redisService = (RedisService) xmlWebApplicationContext.getBean("redisService");

        String verifyCode = request.getParameter("verify_code");
        String redisVerifyCode = (String) redisService.get(request.getLocalAddr());
        if (StringUtils.isEmpty(verifyCode) && StringUtils.isEmpty(redisVerifyCode)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!verifyCode.equals(redisService.get(request.getLocalAddr()))) {
            response.getWriter().println("{\"code\":\"-1\",\"message\": \" Please input the verify code. \"}");
            return;
        }

        filterChain.doFilter(request, response);
        return;
    }
}
