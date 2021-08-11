package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;

@Log4j2
public enum TimeDAO {

    INSTANCE;

    private static final String SQL = "select now()";

    public String getTime() {

        StringBuffer buffer = new StringBuffer();

        new JdbcTemplate() {
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
