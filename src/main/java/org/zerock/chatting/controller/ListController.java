package org.zerock.chatting.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListController", value = "/list")
@Log4j2
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("doGet READY..........");

        request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request,response);


    }
}