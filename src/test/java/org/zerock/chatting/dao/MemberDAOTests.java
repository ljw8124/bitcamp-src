package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.chatting.dto.MemberDTO;

@Log4j2
public class MemberDAOTests {

    @Test
    public void loginTest() throws RuntimeException {

        log.info("login test......");
        MemberDTO result = MemberDAO.INSTANCE.login("user1", "user1");
        log.info(result);
    }
}
