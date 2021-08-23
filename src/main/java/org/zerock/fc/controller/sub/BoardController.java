package org.zerock.fc.controller.sub;

import lombok.extern.log4j.Log4j2;
import org.zerock.fc.annotations.Controller;
import org.zerock.fc.annotations.GetMapping;
import org.zerock.fc.annotations.PostMapping;
import org.zerock.fc.dto.BoardDTO;
import org.zerock.fc.dto.PageDTO;
import org.zerock.fc.dto.PageMaker;
import org.zerock.fc.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller(value = "/board/register.do")
@Log4j2
public class BoardController {

    //String을 Integer로 변환하는 메서드
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

    @PostMapping("/board/remove.do")
    public String deletePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer bno = Integer.parseInt(request.getParameter("bno"));

        BoardService.INSTANCE.remove(bno);

        return "re:/board/list.do";
    }

    @GetMapping("/board/modify.do")
    public String updateGET(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("update doGet..............");
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

        return "board/modify";
    }

    @PostMapping("/board/modify.do")
    public String updatePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer bno = getInt(request.getParameter("bno")); //bno도 가져와야 업데이트가능!
        String modifyTitle = request.getParameter("title");
        String modifyContent = request.getParameter("content");

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(bno)
                .title(modifyTitle)
                .content(modifyContent)
                .build();

        BoardService.INSTANCE.modify(boardDTO);
        return "re:/board/list.do";
    }

    @GetMapping("/board/register.do")
    public String registerGET(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("board register get....");

        return "board/register";
    }

    @PostMapping("/board/register.do")
    public String registerPost(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("board register post....do");

        BoardDTO boardDTO = BoardDTO.builder()
                .title(request.getParameter("title"))
                .content(request.getParameter("content"))
                .writer(request.getParameter("writer"))
                .build();

        Integer bno = BoardService.INSTANCE.register(boardDTO);

        return "re:/board/list.do";
    }


    @GetMapping(value = "/board/list.do")
    public String list (HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("controller list start.........................");

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

        System.out.println("---------------------------");

        return "board/list";
    }

    @GetMapping(value = "/board/read.do")
    public String read(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        return "board/read";
    }

}
