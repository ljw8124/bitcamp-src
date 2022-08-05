package org.zerock.projectboard.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.projectboard.dto.BoardDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public enum BoardDAO {
    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_board (title,content,writer)\n" +
            "values (?,?,?)";

    private static final String SQL_LIST = "select bno,title,writer,regdate,viewcount\n" +
            "from tbl_board\n" +
            "order by bno desc";

    private static final String SQL_READ = "select bno,title,content,writer,regdate,viewcount\n" +
            "from tbl_board\n" +
            "where bno = ?";

    private static final String SQL_UPDATE_VIEWCOUNT = "update tbl_board set viewcount = (viewcount + 1)\n" +
            "where bno = ?\n";

    private static final String SQL_MODIFY = "update tbl_board set title = ?,content = ?\n" +
            "where bno = ?\n";

    private static final String SQL_DELETE = "delete from tbl_board where bno = ?";


    public void insert(BoardDTO boardDTO) throws RuntimeException {
        log.info("start insert...............");

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_INSERT);
                //title,content,writer
                int idx = 1;
                preparedStatement.setString(idx++, boardDTO.getTitle());
                preparedStatement.setString(idx++, boardDTO.getContent());
                preparedStatement.setString(idx++, boardDTO.getWriter());

                int count = preparedStatement.executeUpdate();
                log.info("COUNT : " + count);

            }
        }.makeAll();
    }

    public List<BoardDTO> list() throws RuntimeException {
        log.info("start list...........");

        List<BoardDTO> dtoList = new ArrayList<>();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_LIST);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    dtoList.add(BoardDTO.builder()
                            .bno(resultSet.getInt(1))
                            .title(resultSet.getString(2))
                            .writer(resultSet.getString(3))
                            .regdate(resultSet.getTimestamp(4))
                            .viewcount(resultSet.getInt(5))
                            .build());
                }
            }
        }.makeAll();

        return dtoList;
    }

    public BoardDTO read(int bno) throws RuntimeException {
        log.info("start read.............");
        BoardDTO boardDTO = BoardDTO.builder().build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_VIEWCOUNT);
                preparedStatement.setInt(1, bno);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                preparedStatement = null;

                preparedStatement = connection.prepareStatement(SQL_READ);
                preparedStatement.setInt(1, bno);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();

                //bno,title,content,writer,regdate
                //viewcount
                boardDTO.setBno(resultSet.getInt(1));
                boardDTO.setTitle(resultSet.getString(2));
                boardDTO.setContent(resultSet.getString(3));
                boardDTO.setWriter(resultSet.getString(4));
                boardDTO.setRegdate(resultSet.getTimestamp(5));

                boardDTO.setViewcount(resultSet.getInt(6));
            }
        }.makeAll();

        return boardDTO;
    }

    public void modify(String title, String content, int bno) throws RuntimeException{
        log.info("start modify.............");

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_MODIFY);
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, content);
                preparedStatement.setInt(3, bno);
                int count = preparedStatement.executeUpdate();
                log.info(count);
            }
        }.makeAll();
    }

    public void remove(int bno) {
        log.info("start remove..............");

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_DELETE);
                preparedStatement.setInt(1,bno);
                preparedStatement.executeUpdate();
            }
        }.makeAll();
    }


}
