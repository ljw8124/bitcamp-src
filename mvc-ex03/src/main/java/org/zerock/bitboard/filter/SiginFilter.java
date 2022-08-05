package org.zerock.bitboard.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "signin", urlPatterns = {"/board/register", "/board/read"})
@Log4j2
public class SiginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //init() 메서드는 처음 딱 한번만 호출
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { //URL 들어올때마다 doFilter() 호출
        log.info("Signin Filter..........run................");
//
//        HttpServletRequest req = (HttpServletRequest) request; //다운캐스팅필요
//        HttpServletResponse res = (HttpServletResponse) response; //다운캐스팅 필요
//
//        HttpSession session = req.getSession();
//
//        //not yet login
//        if (session.getAttribute("member") == null) {
//            res.sendRedirect("/login");
//            return;
//        }
        chain.doFilter(request,response); //chain으로 연결하는 메서드

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
