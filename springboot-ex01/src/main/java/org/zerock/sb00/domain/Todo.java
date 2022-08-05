package org.zerock.sb00.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity //Entity는 pk가 필요
//테이블 이름을 따로 주고 싶을 때
@Table(name = "tbl_todo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //수동으로 만드는것이 아니라 자동으로 만들어지는 값을 넣어라 -> AI할 때 이용
    private Long tno; //기본자료형은 pk 불가, 기본적으로 DB에서 숫자는 Long을 더 많이 사용함

    private String title;

    private LocalDate dueDate;

    private boolean completed;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime modDate;

}
