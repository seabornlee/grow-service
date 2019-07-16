package com.oocl.grow.repository;

import com.oocl.grow.model.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test(expected = ConstraintViolationException.class)
    public void todo_text_length_should_not_less_than_3() {
        Todo todo = Todo.builder().text("12").build();
        todoRepository.save(todo);
    }

    @Test(expected = ConstraintViolationException.class)
    public void todo_text_length_should_not_more_than_15() {
        Todo todo = Todo.builder().text("abcde abcde abcd").build();
        todoRepository.save(todo);
    }
}