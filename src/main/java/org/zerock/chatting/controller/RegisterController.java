package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MsgDTO;
import org.zerock.chatting.service.MsgService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/msg/register")
@Log4j2
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("등록 화면 조회");

        HttpSession session = request.getSession();
        Object memberObj = session.getAttribute("member");
        if (memberObj == null) {
            log.info("잘못된 접근입니다.");
            response.sendRedirect("/login");
            return; //return이 중요함!
        }
        request.getRequestDispatcher("/WEB-INF/msg/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request에서 받는 파라미터 한글처리하는 코드
        request.setCharacterEncoding("UTF-8");

        String who = request.getParameter("who");
        String whom = request.getParameter("whom");
        String content = request.getParameter("content");

        log.info("who : " + who);
        log.info("whom : " + whom);
        log.info("content : " + content);

        MsgDTO msgDTO = MsgDTO.builder()
                .who(who)
                .whom(whom)
                .content(content)
                .build();
        //MsgService.register() 호출
        MsgService.INSTANCE.register(msgDTO);
        //redirect
        response.sendRedirect("/msg/list?whom=" + who);

    }
}
