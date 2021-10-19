package org.zerock.sb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.sb.dto.DiaryDTO;

@Transactional
public interface DiaryService {

    Long register(DiaryDTO diaryDTO);

    DiaryDTO read(Long dno);

}
