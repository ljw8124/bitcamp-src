package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MsgDTO;
import org.zerock.chatting.service.MsgService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log4j2
@WebServlet(name = "ListController", value = "/msg/list")
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("list controller doGet.............");

        //설계문 그대로 가야하기 때문에 초기 설계가 중요함
        String user = request.getParameter("whom");

        Map<String, List<MsgDTO>> result = MsgService.INSTANCE.getList(user);

        //jsp(view)로 택배 전달의 역할이 .setAttribute
        request.setAttribute("Receive",result.get("R"));
        request.setAttribute("Send", result.get("S"));

        request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request, response);
    }

}
