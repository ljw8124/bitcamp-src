package org.zerock.sb.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;

@Log4j2
public class JWTUtil {

    private final static String secretKey = "helloworld11111111111111111111111122222222222333333333444444444"; //변환될 문자열

    private SecretKey key;

    public JWTUtil() { //key 암호화
        key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String content) throws RuntimeException{

        long timeAmount = 10;

        String jws = Jwts.builder() // (1)
                .setSubject(content) // (2)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(timeAmount).toInstant()))
                .signWith(key, SignatureAlgorithm.HS256) // (3)
                .compact();//문자열 생성 (4)

        return jws;
    }

    public void validateToken(String token) throws JwtException{
        Jws<Claims> jws = Jwts.parserBuilder() // (1)
                .setSigningKey(key) // (2)
                .build() // (3)
                .parseClaimsJws(token); // (4)
    }
}
