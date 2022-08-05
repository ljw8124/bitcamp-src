package org.zerock.sb.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.web.filter.OncePerRequestFilter;
import org.zerock.sb.security.util.JWTUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
public class TokenCheckFilter extends OncePerRequestFilter {

    private JWTUtil jwtUtil;

    public TokenCheckFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("---------------------------TokenCheckFilter-------------------------------");

        String path = request.getRequestURI();

        log.info(path);

        if(path.startsWith("/api/")) {
            //api로 들어온다면 check token
            String authToken = request.getHeader("Authorization");

            if(authToken == null) {
                log.info("authToken is null...........................");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                // json 리턴
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = new JSONObject();
                String message = "FAIL CHECK API TOKEN";
                json.put("code", "403");
                json.put("message", message);

                PrintWriter out = response.getWriter();
                out.print(json);
                out.close();
                return;
            }//if end

            //JWT 검사 -> 맨 앞에 인증 타입 Bearer 존재
            String tokenStr = authToken.substring(7); //Bearer가 여섯글자
            try {
                jwtUtil.validateToken(tokenStr);
            }catch(ExpiredJwtException ex) {

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                // json 리턴
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = new JSONObject();
                String message = "EXPIRED API TOKEN.. TOO OLD";
                json.put("code", "401");
                json.put("message", message);

                PrintWriter out = response.getWriter();
                out.print(json);
                out.close();
                return;
            }catch(JwtException jex) {

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                // json 리턴
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = new JSONObject();
                String message = "YOUR ACCESS TOKEN IS INVALID!";
                json.put("code", "401");
                json.put("message", message);

                PrintWriter out = response.getWriter();
                out.print(json);
                out.close();
                return;

            }

            filterChain.doFilter(request, response);

        } else {
            log.info("---------------------------TokenCheckFilter-------------------------------");

            //다음단계 진행
            filterChain.doFilter(request, response);
        } //if end



    }
}
