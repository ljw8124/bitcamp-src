package org.zerock.bitboard.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;

import java.util.List;

@Log4j2
public enum BoardDAO {

    INSTANCE;

    private static final String PREFIX = "org.zerock.bitboard.dao.BoardMapper";

    public Integer insert(BoardDTO boardDTO) throws RuntimeException {

        Integer bno = null;

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            session.insert(PREFIX + ".insert", boardDTO);
            bno = boardDTO.getBno();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
        return bno;
    }

    public BoardDTO select(Integer bno) throws RuntimeException {
        BoardDTO boardDTO = null;

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            session.update(PREFIX + ".updateViewcount", bno);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }

        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            boardDTO = session.selectOne(PREFIX + ".select", bno); //한 건 가져올때 selectOne
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
        return boardDTO;
    }

    public List<BoardDTO> list(PageDTO pageDTO) throws RuntimeException {
        log.info("list start............");
        List<BoardDTO> list = null;
        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            list = session.selectList(PREFIX + ".list", pageDTO);//한 건 이상 가져올때 selectList
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
        return list;
    }

    public void update(BoardDTO boardDTO) throws RuntimeException {
        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            session.update(PREFIX + ".update", boardDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
    }

    public void delete(Integer bno) throws RuntimeException {
        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            session.delete(PREFIX + ".delete", bno);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
    }

    public int getTotal() throws RuntimeException {
        int total = 0;
        try (SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession(true)) { //openSession에 true를 주면 autoCommit됨.
            total = session.selectOne(PREFIX + ".totalCount");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage()); //예외 잡아서 던지기!
        }
        return total;
    }


}
