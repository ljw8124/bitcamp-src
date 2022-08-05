package org.zerock.bitboard.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public enum MyBatisLoader { //enum은 lombok 사용에 제한이 많음
    INSTANCE;

    private SqlSessionFactory sqlSessionFactory; //mySql서버와 myBatis를 연결해줌

    MyBatisLoader() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getFactory() {
        return this.sqlSessionFactory;
    }

}
