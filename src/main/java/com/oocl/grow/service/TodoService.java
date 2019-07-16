package com.oocl.grow.service;

import com.oocl.grow.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAllTodos();

    Todo createTodo(Todo todo);
}
