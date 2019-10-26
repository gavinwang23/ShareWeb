package com.share.handler;

import com.share.common.CommonEnum;
import com.share.service.UsersStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsersStationService usersStationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        usersStationService.updateLoginTimeByUserName(authentication.getName(), new Date());
        this.returnJson(response, authentication);
    }

    private void returnJson(HttpServletResponse response, Authentication authentication) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding(CommonEnum.UTF_8.getMessage());
        response.setContentType(CommonEnum.APPLICATION_JSON.getMessage());
        response.getWriter()
                .println("{\"code\":\"200\",\"tokenType\":\"Bearer\",\"token\": \""
                        + jwtTokenProvider.createJwtToken(authentication) + "\"}");

    }
}