package com.share.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {
    //Token过期时间5分钟
    private static final Long EXPIRE_TIME = Long.valueOf(5 * 60 * 1000);

    //盐/私钥
    private static final String SECRET = "为了理想,为了未来,我们携手在涛涛的松花江畔";

    /**
     * 创建token, 默认过期时间为5分钟
     * @param username
     * @return
     */
    public static String createJwtToken(String username) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create().withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 创建token, 可以设定过期时间
     * @param username
     * @param expireTime
     * @return
     */
    public static String createJwtToken(String username, Long expireTime) {
        Date date = new Date(System.currentTimeMillis() + expireTime);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create().withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验token是否正确
     * @param token
     * @param username
     * @return
     */
    public static Boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            verifier.verify(token);
            return Boolean.TRUE;
        } catch (Exception exception) {
            return Boolean.FALSE;
        }
    }

    /**
     * 不使用密钥强行获得token中的信息
     * @param token
     * @return
     */
    public static String getTokenUsernameWithoutSecret(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
