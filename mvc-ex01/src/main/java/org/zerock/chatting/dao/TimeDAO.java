package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum TimeDAO {

    INSTANCE; //enum을 사용하려면 INSTANCE를 호출하여 재새용해야함. -> 의존성 해방방법

    private static final String SQL = "select now()"; //변하지않는 코드는 final 로 선언언

   public String getTime() throws RuntimeException {

       StringBuffer buffer = new StringBuffer();

        new org.zerock.chatting.dao.JdbcTemplate() {
            @Override
            protected void execute() throws Exception {
                preparedStatement = connection.prepareStatement(SQL);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                buffer.append(resultSet.getString(1));
            }
        }.makeAll();

        return buffer.toString();
    }
}
