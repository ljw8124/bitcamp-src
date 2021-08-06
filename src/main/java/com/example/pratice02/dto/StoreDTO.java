package com.example.pratice02.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class StoreDTO {

    private String name;
    private String area;
    private String desc;
    private String link;

}
