package com.share.handler;

import com.share.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class LoginWebAuthenticationDetails extends WebAuthenticationDetails {
    private String verifyCode;
    private String username;
    private String password;

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    private String ipAddr;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Records the remote address and will also set the session Id if a session
     * already exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public LoginWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        username = request.getParameter("username");
        password = request.getParameter("password");
        verifyCode = request.getParameter("verify_code");
        ipAddr = request.getRemoteAddr();
    }
}
