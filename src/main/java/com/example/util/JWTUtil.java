package com.example.util;

import com.example.exp.UnAuthorizedException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JWTUtil {

    private static String secretKey ="2sms2provider";

    private static  int tokenLiveTime=1000 * 3600 * 24*7 ;

    public static String encode(Integer id) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);

        jwtBuilder.claim("id", id);

        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLiveTime)));
        jwtBuilder.setIssuer("SMS provider");

        return jwtBuilder.compact();
    }

    public static Integer decode(String token) {
        try {
            JwtParser jwtParser = Jwts.parser();
            jwtParser.setSigningKey(secretKey);
            Jws<Claims> jws = jwtParser.parseClaimsJws(token);
            Claims claims = jws.getBody();
            return (Integer) claims.get("id");
        } catch (JwtException e) {
            throw new UnAuthorizedException("Your session expired");
        }
    }



}
