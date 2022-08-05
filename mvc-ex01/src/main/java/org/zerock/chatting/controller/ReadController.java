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

@WebServlet(name = "ReadController", value = "/msg/read")
@Log4j2
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object memberObj = session.getAttribute("member");
        if (memberObj == null) {
            log.info("잘못된 접근입니다.");
            response.sendRedirect("/login");
            return; //return이 중요함!
        }

        long mno = Long.parseLong(request.getParameter("mno"));

        MsgDTO msgDTO = MsgService.INSTANCE.read(mno);

        request.setAttribute("dto", msgDTO);
        request.getRequestDispatcher("/WEB-INF/msg/read.jsp").forward(request, response);


    }

}
