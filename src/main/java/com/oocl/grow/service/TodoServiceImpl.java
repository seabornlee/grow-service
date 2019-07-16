package com.oocl.grow.service;

import com.oocl.grow.model.Todo;
import com.oocl.grow.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {
        if (todo.isCompleted()) {
            throw new IllegalArgumentException();
        }

        if (isExisted(todo)) {
            throw new IllegalArgumentException();
        }
        return todoRepository.save(todo);
    }

    private boolean isExisted(Todo todo) {
        return todoRepository.findTodoByTextAndCompleted(todo.getText(), todo.isCompleted()) != null;
    }
}
