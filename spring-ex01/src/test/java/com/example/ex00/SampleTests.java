package com.example.ex00;

import com.example.ex00.sample.Restaurant;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //경로 지정 필요
public class SampleTests {

    @Autowired //옆 그림 모양을 bin이라고 함, 자동으로 주입하라는 어노테이션
    ApplicationContext applicationContext;

    @Autowired
    Restaurant restaurant;

    @Autowired
    DataSource dataSource;

    @Test //데이터베이스 연결하는 test code
    public void testConnect() throws Exception {

        for(int i = 0 ; i < 100; i++) { //백번 열고 닫기
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            log.info(resultSet.getString(1));

            //다 썼으면 닫기! myBatis로 자동 열고 닫기 필요
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
    }

    @Test //spring이 제대로 작동하는지 알아보는 test code
    public void test1() {
        log.info("무~~~~야~~호~~~~~~~~~");
        log.info("무~~~~야~~호~~~~~~~~~");
        log.info(dataSource); //null이 나오면 비정상. @~~가 나온다면 테스트환경 구축 완료.
        log.info("무~~~~야~~호~~~~~~~~~");
        log.info("무~~~~야~~호~~~~~~~~~");
    }

}
