package org.zerock.chatting.controller;

import com.mysql.cj.Session;
import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MemberDTO;
import org.zerock.chatting.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "LoginController", value = "/login" )
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login doGet..........");
        request.getRequestDispatcher("WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //mid,mpw,mname,nickname,joindate
        //moddate
        try {
            String mid = request.getParameter("mid");
            String mpw = request.getParameter("mpw");

            log.info("login doPost......");
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            log.info(memberDTO);

            HttpSession session = request.getSession();
            session.setAttribute("member", memberDTO);
            //로그인 성공시 msg/list로 리다이렉트
            response.sendRedirect("/msg/list");
        } catch(Exception e) {
            log.info("login failed.........." + e);
            //실패시 로그인 화면으로 리다이렉트
            response.sendRedirect("/login?result=fail");
        }


    }
}
