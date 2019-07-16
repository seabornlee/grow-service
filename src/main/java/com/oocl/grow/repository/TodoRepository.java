package com.oocl.grow.repository;

import com.oocl.grow.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findTodoByTextAndCompleted(String text, boolean completed);
}
