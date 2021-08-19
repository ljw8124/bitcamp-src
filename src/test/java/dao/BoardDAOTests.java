package dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.bitboard.dao.BoardDAO;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;

@Log4j2
public class BoardDAOTests {

    @Test
    public void insertTest() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("test title")
                .content("test content")
                .writer("test user")
                .build();

        BoardDAO.INSTANCE.insert(boardDTO);

        log.info("==========================");
        log.info(boardDTO);
    }

    @Test
    public void selectTest() {
        log.info(BoardDAO.INSTANCE.select(3));
    }

    @Test
    public void listTest() {

        PageDTO pageDTO = PageDTO.builder().page(3).build();

        BoardDAO.INSTANCE.list(pageDTO).forEach(boardDTO -> log.info(boardDTO));
    }

    @Test
    public void updateTest() {

        BoardDTO boardDTO = BoardDTO.builder().title("안녕하세요").content("안녕히가세요").bno(229356).build();

        BoardDAO.INSTANCE.update(boardDTO);
    }

    @Test
    public void delelteTest() {

        BoardDAO.INSTANCE.delete(262133);
    }
}
