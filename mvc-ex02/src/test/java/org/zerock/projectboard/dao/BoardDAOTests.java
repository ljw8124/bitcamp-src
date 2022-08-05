package org.zerock.projectboard.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.projectboard.dto.BoardDTO;

import java.util.stream.IntStream;

@Log4j2
public class BoardDAOTests {
    @Test
    public void insertTest() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            String title = "sample" + i;
            String content = "sample content" + i;
            String writer = "user" + +(int) (Math.random() * 10 + 1);


            BoardDTO boardDTO = BoardDTO.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();

            BoardDAO.INSTANCE.insert(boardDTO);
        });
    }
    @Test
    public void listTest() {
        log.info(BoardDAO.INSTANCE.list());
    }

    @Test
    public void readTest() {
        log.info("read.....");
        log.info(BoardDAO.INSTANCE.read(6));
    }


    @Test
    public void modifyTest() {
        log.info("modify.......");

       String title = "무야호호호호호";
        String content = "무야호호호호호호무야호호";
        int bno = 3;

        BoardDAO.INSTANCE.modify(title, content, bno);
    }

    @Test
    public void removeTest() {
        log.info("remove..........");

        int bno = 28;

        BoardDAO.INSTANCE.remove(bno);
    }

}
