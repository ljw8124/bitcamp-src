package org.zerock.chatting.service;


import lombok.extern.log4j.Log4j2;
import org.zerock.chatting.dao.MsgDAO;
import org.zerock.chatting.dto.MsgDTO;


import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgService {
    INSTANCE;

    public void register(MsgDTO msgDTO) throws RuntimeException {

        log.info("service register......" + msgDTO);

        MsgDAO.INSTANCE.insert(msgDTO);

    }

    public Map<String, List<MsgDTO>> getList(String user) throws RuntimeException {

        long start = System.currentTimeMillis();

        Map<String, List<MsgDTO>> result = MsgDAO.INSTANCE.selectList(user);

        long end = System.currentTimeMillis();

        log.info("TIME : " + (end - start));

        return result;
    }

    public MsgDTO read(long mno) {

        log.info("read........");

        return MsgDAO.INSTANCE.read(mno);
    }

    public void remove(MsgDTO msgDTO) throws RuntimeException {

        log.info("remove......");

        MsgDAO.INSTANCE.remove(msgDTO.getMno(),msgDTO.getWho());

    }
}



