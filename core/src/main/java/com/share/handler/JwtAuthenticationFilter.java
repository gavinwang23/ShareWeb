package com.share.handler;

import com.share.service.DatabaseUserDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private DatabaseUserDetailsService databaseUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader("Authorization");
        try {
            if (StringUtils.isNotBlank(jwtToken) && jwtToken.startsWith("Bearer")) {
                jwtToken = jwtToken.replace("Bearer ", "");
                getAuthenticationContext(jwtToken);

            } else {
                log.error(request.getParameter("username") + ": Token is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("{\"code\":\"-1\",\"message\": \" Please login again. \"}");
            return;
        }
        super.doFilter(request, response, filterChain);
        return;
    }

    private void getAuthenticationContext(String jwtToken) {
            String username = jwtTokenProvider.getUsernameFromJwt(jwtToken);
            UserDetails userDetails = databaseUserDetailsService.getUserDetailsByUsername(username);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
