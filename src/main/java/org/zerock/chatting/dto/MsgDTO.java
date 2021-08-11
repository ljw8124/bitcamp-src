package org.zerock.chatting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MsgDTO {
    private long mno;
    private String who, whom, content;
    private Timestamp regdate, opendate;
}
