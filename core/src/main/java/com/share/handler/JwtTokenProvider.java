package com.share.handler;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    private final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${jwtTokenSecret}")
    private String SECRET;

    @Value("${jwtTokenExpiredMs}")
    private Long EXPIRE_TIME;

    public String createJwtToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        Date expireTime = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Map claims = new HashMap();
        claims.put("roles", user.getAuthorities());
        String token = Jwts.builder().setSubject(username)
                .setExpiration(expireTime)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .setClaims(claims)
                .compact();

        return token;
    }

    public boolean validateJwtToken(String token) {
        String VALIDATE_FAILED = "validate failed: ";
        try {
            Jwts.parser().setSigningKey(SECRET).parse(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error(VALIDATE_FAILED + e.getMessage());
            return false;
        }
    }

    public String getUsernameFromJwt(String jwtToken) {
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }
}
