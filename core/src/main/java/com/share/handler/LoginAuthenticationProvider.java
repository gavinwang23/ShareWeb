package com.share.handler;

import com.share.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private RedisService redisService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LoginWebAuthenticationDetails details = (LoginWebAuthenticationDetails) authentication.getDetails();
        String verifyCode = details.getVerifyCode();
        String redisVerifyCode = details.getIpAddr();
        if (StringUtils.isEmpty(verifyCode) && StringUtils.isEmpty(redisVerifyCode)) {
            return;
        }

            if (!verifyCode.equalsIgnoreCase((String) redisService.get(request.getLocalAddr()))) {
                response.getWriter().println("{\"code\":\"-1\",\"message\": \" Please input the verify code. \"}");
                return;
            }

        String username = details.getUsername();


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
