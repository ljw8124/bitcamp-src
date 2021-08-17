package org.zerock.projectboard.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dao.BoardDAO;
import org.zerock.projectboard.dto.BoardDTO;

import java.util.List;

@Log4j2
public enum BoardService {
    INSTANCE;

    public void write(BoardDTO boardDTO) {
        log.info("write............");
        BoardDAO.INSTANCE.insert(boardDTO);
    }

    public List<BoardDTO> list() {
        log.info("list.............");
        return BoardDAO.INSTANCE.list();
    }

    public BoardDTO read(int bno) {
        log.info("read...........");
        return BoardDAO.INSTANCE.read(bno);
    }

    public void modify(String title, String content, int bno) {
        log.info("modify.........");
        BoardDAO.INSTANCE.modify(title, content, bno);
    }

    public void remove(int bno) {
        log.info("remove...........");
        BoardDAO.INSTANCE.remove(bno);
    }
}
