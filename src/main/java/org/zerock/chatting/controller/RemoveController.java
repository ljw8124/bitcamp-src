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

@WebServlet(name = "RemoveController", value = "/msg/remove")
@Log4j2
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object memberObj = session.getAttribute("member");
        if (memberObj == null) {
            log.info("잘못된 접근입니다.");
            response.sendRedirect("/login");
            return; //return이 중요함!
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        long mno = Long.parseLong(request.getParameter("mno"));
        String who = request.getParameter("who");

        log.info("mno : " + mno);
        log.info("who : " + who);

        MsgDTO msgDTO = MsgDTO.builder()
                .mno(mno).who(who).build();

        MsgService.INSTANCE.remove(msgDTO);
        response.sendRedirect("/msg/list?whom=" + who);
    }
}
