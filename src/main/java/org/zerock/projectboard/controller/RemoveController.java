package org.zerock.projectboard.controller;

import org.zerock.projectboard.dao.BoardDAO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveController", value = "/board/remove")
public class RemoveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardService.INSTANCE.remove(bno);

        response.sendRedirect("/board/list");
    }
}
