package org.zerock.chatting.dao;

import com.sun.javadoc.MemberDoc;
import org.zerock.chatting.dto.MemberDTO;

public enum MemberDAO {

    INSTANCE;

    private static final String SQL_LOGIN = "select mid,mpw,mname,nickname,joindate,moddate\n" +
            "from tbl_member\n" +
            "where mid = ? and mpw = ?";

    public MemberDTO login(String mid, String mpw) {

        MemberDTO memberDTO = MemberDTO.builder().build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_LOGIN);
                preparedStatement.setString(1, mid);
                preparedStatement.setString(2, mpw);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next() == false) {
                    throw new Exception("NOT EXIST");
                };

                //mid,mpw,mname,nickname,joindate
                //moddate
                memberDTO.setMid(resultSet.getString(1));
                memberDTO.setMpw(resultSet.getString(2));
                memberDTO.setMname(resultSet.getString(3));
                memberDTO.setNickname(resultSet.getString(4));
                memberDTO.setJoindate(resultSet.getTimestamp(5));

                memberDTO.setModdate(resultSet.getTimestamp(6));
            }
        }.makeAll();

        return memberDTO;
    }




}
