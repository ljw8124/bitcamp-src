package org.zerock.chatting.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.chatting.dto.MsgDTO;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Log4j2
public class MsgDAOTests {

    @Test
    public void testMsgInsert(){

        IntStream.rangeClosed(1, 100).forEach(i -> {
            String who = "user" + (int)(Math.random()*10 + 1);
            String whom = "user" + (int)(Math.random()*10 + 1);
            String content = "sample" + i;

            MsgDTO dto = MsgDTO.builder().who(who).whom(whom).content(content).build();
            MsgDAO.INSTANCE.insert(dto);
        });
    }

    @Test
    public void testMsgSelect() {
        Map<String, List<MsgDTO>> result = MsgDAO.INSTANCE.selectList("user3");

        log.info("보낸목록.............");
        List<MsgDTO> receiveList = result.get("R");
        receiveList.forEach(MsgDTO -> log.info(MsgDTO));

        log.info("받은목록.............");
        List<MsgDTO> sendList = result.get("S");
        sendList.forEach(MsgDTO -> log.info(MsgDTO));

    }
}
