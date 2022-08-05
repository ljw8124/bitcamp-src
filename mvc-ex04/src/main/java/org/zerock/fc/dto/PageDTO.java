package org.zerock.fc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO {

    @Builder.Default //null이면 기본값으로 대입하는 어노테이션(객체를 만들자마자),생성자 안만들고 쓰는 방법!
    private int page = 1;
    @Builder.Default
    private int size = 10;

    public int getSkip() { //mybatis는 get과 set으로 동작함
        //1p -> skip 0
        //2p -> skip 10
        //3p -> skip 20

        return (this.page - 1) * size;
    }



}
