package org.zerock.sb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.sb.dto.DiaryDTO;
import org.zerock.sb.entity.Diary;
import org.zerock.sb.repository.diary.DiaryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class DiaryServiceImpl implements DiaryService{

    private final DiaryRepository diaryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(DiaryDTO diaryDTO) {

        Diary diary = modelMapper.map(diaryDTO, Diary.class);

        /*
        log.info(diary);
        log.info(diary.getTags());
        log.info(diary.getPictures());
        */


        diaryRepository.save(diary);

        return diary.getDno();
    }

    @Override
    public DiaryDTO read(Long dno) {

        Optional<Diary> optionalDiary = diaryRepository.findById(dno);

        Diary diary = optionalDiary.orElseThrow(); //예외처리

        DiaryDTO diaryDTO = modelMapper.map(diary, DiaryDTO.class);

        return diaryDTO;
    }
}
