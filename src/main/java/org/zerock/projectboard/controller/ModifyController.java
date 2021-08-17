package org.zerock.projectboard.controller;

import org.zerock.projectboard.dto.BoardDTO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyController", value = "/board/modify")
public class ModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("dto", boardDTO);
        request.getRequestDispatcher("/WEB-INF/board/modify.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardService.INSTANCE.modify(title, content, bno);
        response.sendRedirect("/board/list");

    }
}
