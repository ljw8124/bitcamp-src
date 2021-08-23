package org.zerock.fc.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.fc.dao.BoardDAO;
import org.zerock.fc.dto.BoardDTO;
import org.zerock.fc.dto.PageDTO;

import java.util.List;

@Log4j2
public enum BoardService {
    INSTANCE;

    public BoardDTO read(Integer bno) {
        log.info("BoardService read...........");
        return BoardDAO.INSTANCE.select(bno);
    }

    public List<BoardDTO> list(PageDTO pageDTO) {
        return BoardDAO.INSTANCE.list(pageDTO);
    }

    public int getTotal() {
        return BoardDAO.INSTANCE.getTotal();
    }

    public Integer register(BoardDTO boardDTO) throws RuntimeException {
        log.info("BoardService register...............");
        return BoardDAO.INSTANCE.insert(boardDTO);
    }

    public void modify(BoardDTO boardDTO) throws RuntimeException {
        log.info("BoardService update..............");
        BoardDAO.INSTANCE.update(boardDTO);
    }

    public void remove(Integer bno) throws RuntimeException {
        log.info("BoardService remove.........");
        BoardDAO.INSTANCE.remove(bno);
    }



}
