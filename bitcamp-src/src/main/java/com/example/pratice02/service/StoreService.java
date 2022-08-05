package com.example.pratice02.service;

import com.example.pratice02.dto.StoreDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum StoreService {

    INSTANCE; //enum은 상수처럼 대문자로 정의

    private List<StoreDTO> dtoList;

    StoreService() {
        dtoList = new ArrayList<>();

        this.add(StoreDTO.builder().name("수정식당").area("종각").desc("불백").build());
        this.add(StoreDTO.builder().name("창매족").area("석계").desc("족발").build());
        this.add(StoreDTO.builder().name("아리닭발").area("김포").desc("닭발").build());
        this.add(StoreDTO.builder().name("은행나무집").area("종각").desc("한우국밥").build());

    }

    public void add(StoreDTO storeDTO) {
        this.dtoList.add(storeDTO); //this.는 생략가능
    }

    public List<StoreDTO> getDtoList(String area) {
        if (area == null || area.trim().length() == 0) {
            return this.dtoList; //area가 등록되어있지 않다면 그냥 전체 리스트를 출력
        }
        return this.dtoList.stream().filter(storeDTO -> storeDTO.getArea().equals(area)).collect(Collectors.toList());
        //stream은 list를 한줄로 쭉 펴는 느낌. filter는 말그대로 조건에 (위 코드는 조건을 람다식으로 표현) filtering하는 것
    }

}


