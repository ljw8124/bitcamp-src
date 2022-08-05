package org.zerock.sb00.repositories;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb00.domain.Todo;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired //에러가 나는 버전이 있음. (required = false)를 쓰면 해결!
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {

        Todo todo = Todo.builder()
                .title("Todo....")
                .dueDate(LocalDate.now().plusDays(7))
                .build();

        todoRepository.save(todo);
    }

}
