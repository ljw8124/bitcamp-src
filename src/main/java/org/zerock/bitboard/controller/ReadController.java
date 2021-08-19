package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;
import org.zerock.bitboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadController", value = "/board/read")
@Log4j2
public class ReadController extends HttpServlet {

    private Integer getInt(String str) {
        try {
            int value = Integer.parseInt(str);
            if (value <= 0) { //페이지를 음수로 넣은경우 1페이지로 보내는 조건문
                return null;
            }
            return value;
        } catch (Exception e) {
            return null; //예외가 발생할 경우 1페이지로 보내준다(String으로 입력하는 경우)
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = getInt(request.getParameter("bno"));
        Integer page = getInt(request.getParameter("page"));
        Integer size = getInt(request.getParameter("size"));

        PageDTO pageDTO = PageDTO.builder().build();

        if (page != null) { pageDTO.setPage(page); }
        if (size != null) { pageDTO.setSize(size); }

        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);
        log.info(boardDTO);

        request.setAttribute("boardDTO", boardDTO);
        request.setAttribute("pageDTO", pageDTO);

        request.getRequestDispatcher("/WEB-INF/board/read.jsp").forward(request,response);

    }

}
