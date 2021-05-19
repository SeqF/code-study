package com.quibbler.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author paksu
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

    private long expire;

    private String secret;

    private String header;

    /**
     * 生成JWT
     *
     * @param username
     * @return
     */
    public String generateToken(String username) {

        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000 * expire);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
    }

    /**
     * 解析JWT
     *
     * @param jwt
     * @return
     */
    public Claims getClaimByToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJwt(jwt)
                    .getBody();
        } catch (Exception e) {
            //抛出异常则返回空
            return null;
        }
    }

    /**
     * 判断JWT是否过期
     *
     * @param claims
     * @return
     */
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
