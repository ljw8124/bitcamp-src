package com.example.ex00.sample;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@ToString
@Component
//@RequiredArgsConstructor // 객체를 생성하고 injection 이 자동으로 되는 코드 -> 생성자 주입
@Setter
public class Restaurant {

//    @Qualifier("koreanChef") //Qualifier를 사용하여 여러개 bin 중에 어떤 bin를 부를건지 선택
    @Autowired
    private Chef chef; //bin injection 했다는 이미지, 4.3버전 이후로는 final로 선언하여 사용

}
