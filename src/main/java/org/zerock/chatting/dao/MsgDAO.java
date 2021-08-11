package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dto.MsgDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgDAO {
    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_msg (who,whom,content) values (?, ?, ?)";
    private static final String SQL_SELECT = "select mno, who, whom, if(who = ?, 'R', 'S') kind, content, regdate, opendate\n" +
            "from\n" +
            "tbl_msg\n" +
            "where\n" +
            "whom = ? or who = ?\n" +
            "order by kind asc, mno desc";

    public void msgInsert(MsgDTO msgDTO) {


        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_INSERT);

                int idx = 1;

                preparedStatement.setString(idx++, msgDTO.getWho());
                preparedStatement.setString(idx++, msgDTO.getWhom());
                preparedStatement.setString(idx++, msgDTO.getContent());
                int count = preparedStatement.executeUpdate();
                log.info("COUNT : " + count);

            }
        }.makeAll();
    }

    public Map<String, List<MsgDTO>> msgSelectList(String user) {
        Map<String, List<MsgDTO>> listMap = new HashMap<>();
        listMap.put("R", new ArrayList<>());
        listMap.put("S", new ArrayList<>());

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL_SELECT);
                int idx = 1;
                preparedStatement.setString(idx++, user);
                preparedStatement.setString(idx++, user);
                preparedStatement.setString(idx++, user);

                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    String kind = resultSet.getString(4);
                    //resultSet에 저장된 데이터중 4번째 인덱스에 존재하는 값을 kind로 부름

                    List<MsgDTO> targetList = listMap.get(kind);
                    // List에 MsgDto 형식으로 넣은 리스트를 targetList라고 하는데
                    // 그것을 listMap에서 kind에 따라서 가져와라
                    // mno, who, whom, if(whom = ?, 'R', 'S') kind, content,
                    // regdate, opendate
                    targetList.add(MsgDTO.builder()
                            .mno(resultSet.getLong(1))
                            .who(resultSet.getString(2))
                            .whom(resultSet.getString(3))
                            .content(resultSet.getString(5))
                            .regdate(resultSet.getTimestamp(6))
                            .opendate(resultSet.getTimestamp(7))
                            .build());
                }
            }
        }.makeAll();

        return listMap;
    }

}
