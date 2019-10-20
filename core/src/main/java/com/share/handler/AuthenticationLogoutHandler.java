package com.share.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            for (Cookie cookie : request.getCookies()) {
                if (cookie != null) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            response.getWriter().println("{\"code\":\"0\",\"message\": \" Logout successful. \"}");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //因为已经登出,不必再理会服务器内的错误,直接返回成功
                response.getWriter().println("{\"code\":\"0\",\"message\": \" Logout successful. \"}");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return;
    }
}
