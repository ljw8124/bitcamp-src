package org.zerock.sb00.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sb00.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
