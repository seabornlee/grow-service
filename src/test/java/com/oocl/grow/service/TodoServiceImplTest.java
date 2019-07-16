package com.oocl.grow.service;

import com.oocl.grow.model.Todo;
import com.oocl.grow.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImplTest {

    @InjectMocks
    TodoServiceImpl todoService;

    @Mock
    TodoRepository todoRepository;


    @Test(expected = IllegalArgumentException.class)
    public void should_not_save_incomplete_todo_with_duplicated_text() {
        Todo todo = Todo.builder().id(1l).text("learn TDD").completed(false).build();
        when(todoRepository.findTodoByTextAndCompleted(todo.getText(), todo.isCompleted())).thenReturn(todo);

        todoService.createTodo(todo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_save_completed_todo() {
        Todo todo = Todo.builder().text("learn TDD").completed(true).build();
        todoService.createTodo(todo);
    }
}