package org.zerock.fc.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

@Log4j2
public class TiemDAOTests {

    @Test
    public void test1() throws Exception {
        log.info("test log.................");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        log.info(sqlSessionFactory);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            String timeStr = session.selectOne("org.zerock.fc.dao.TimeMapper.getTime");
            log.info("===========================");
            log.info(timeStr);
            log.info("---------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testTime() {
        log.info("testTime....................");
        log.info(TimeDAO.INSTANCE.getTime());
    }

}
