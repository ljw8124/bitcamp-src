package org.zerock.sb.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb.security.util.JWTUtil;

@SpringBootTest
@Log4j2
public class JWTTests {

    @Autowired
    JWTUtil jwtUtil;

    @Test
    public void TestGenerate() {

        String jwtStr = jwtUtil.generateToken("user80");

        log.info(jwtStr);
    }

    @Test
    public void testValidate() {

        //유효한 토큰
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMTEiLCJpYXQiOjE2MzQ4NjkwNTgsImV4cCI6MTYzNDg3MjY1OH0.XicwrTtjTqMrW0IRzWsTmKStYDaRyhHHGPF-01oK8KM";

        try {
            jwtUtil.validateToken(str);
        }catch (ExpiredJwtException ex) {
            log.error("JWT expired.....................................");
            log.error(ex.getMessage());

        }catch (JwtException ex) {
            log.error("JWTException....................................");
            log.error(ex.getMessage());
        }
    }

}
