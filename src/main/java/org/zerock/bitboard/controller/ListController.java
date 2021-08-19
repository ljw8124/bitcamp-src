package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.graalvm.libgraal.jni.annotation.FromLibGraalEntryPointsResolver;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;
import org.zerock.bitboard.dto.PageMaker;
import org.zerock.bitboard.service.BoardService;
import sun.jvm.hotspot.gc.z.ZPage;
import sun.jvm.hotspot.gc.z.ZPageAllocator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {

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
        log.info("controller list start............");

        Integer page = getInt(request.getParameter("page"));
        Integer size = getInt(request.getParameter("size"));
        int total = BoardService.INSTANCE.getTotal();

        PageDTO pageDTO = PageDTO.builder().build();

        if (page != null) {
            pageDTO.setPage(page);
        }
        if (size != null) {
            pageDTO.setSize(size);
        }
        log.info("===============================");
        log.info(pageDTO);



        PageMaker pageMaker = new PageMaker(pageDTO.getPage(), pageDTO.getSize(), total);
        request.setAttribute("pageMaker", pageMaker);

        List<BoardDTO> dtoList = BoardService.INSTANCE.list(pageDTO);
        request.setAttribute("list", dtoList);
        request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);

    }


}
