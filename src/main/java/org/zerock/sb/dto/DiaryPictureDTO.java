package org.zerock.sb.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "uuid")
public class DiaryPictureDTO {

    private String uuid;
    private String fileName;
    private String savaPath;
    private int idx;

}
