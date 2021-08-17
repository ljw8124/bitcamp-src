package org.zerock.projectboard.controller;

import org.zerock.projectboard.dao.BoardDAO;
import org.zerock.projectboard.dto.BoardDTO;
import org.zerock.projectboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BoardDTO> dtoList = BoardService.INSTANCE.list();

        request.setAttribute("list", dtoList);

        request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request,response);

    }

}
