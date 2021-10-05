package org.zerock.sb01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {

    private Long sno;
    private String title;
    private LocalDateTime regdate;

}
