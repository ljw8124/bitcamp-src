package org.zerock.projectboard.controller;

import org.zerock.projectboard.dao.BoardDAO;
import org.zerock.projectboard.dto.BoardDTO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WriteController", value = "/board/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       request.getRequestDispatcher("/WEB-INF/board/write.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");

        BoardDTO boardDTO = BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        BoardService.INSTANCE.write(boardDTO);
        response.sendRedirect("/board/list");
    }
}
