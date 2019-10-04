package com.share.handler;

import com.share.common.CommonEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        System.out.println("User: " + request.getParameter("username") + " Login successfully.");
        this.returnJson(response);
    }

    private void returnJson(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding(CommonEnum.UTF_8.getName());
        response.setContentType(CommonEnum.APPLICATION_JSON.getName());
        response.getWriter().println("{\"exceptionId\":\"null\",\"messageCode\":\"200\"," +
                "\"message\": \"Login successfully.\",\"serverTime\": " + System.currentTimeMillis() + "}");

    }
}