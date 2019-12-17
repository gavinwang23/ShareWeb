package com.share.handler;

import com.share.entity.UsersStation;
import com.share.redis.RedisService;
import com.share.service.UsersStationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private RedisService redisService;

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Autowired
    private UsersStationService usersStationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LoginWebAuthenticationDetails details = (LoginWebAuthenticationDetails) authentication.getDetails();
        String verifyCode = details.getVerifyCode();
        String redisVerifyCode = (String) redisService.get(details.getIpAddr());
        if (!StringUtils.isEmpty(verifyCode) && StringUtils.isEmpty(redisVerifyCode)
                || StringUtils.isEmpty(verifyCode) && !StringUtils.isEmpty(redisVerifyCode)) {
            return null;
        }

        if (!StringUtils.isEmpty(verifyCode) && !StringUtils.isEmpty(redisVerifyCode) && !verifyCode.equalsIgnoreCase(redisVerifyCode))
            return null;

        String username = details.getUsername();
        List<UsersStation> users = usersStationService.getUsersStationByUsername(username);
        if (users == null || users.size() == 0)
            throw new UsernameNotFoundException("User + " + username + " not found.");
        if (users.size() > 1)
            throw new UsernameNotFoundException("User + " + username + " has too many, please contact our engineer.");

        String password = md5PasswordEncoder.encodePassword(details.getPassword(), "");
        UsersStation user = users.get(0);
        if (!user.getUserPassword().equals(password))
            throw new UsernameNotFoundException("Please input the correct password of " + username);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorityList);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
