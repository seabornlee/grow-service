package com.oocl.grow.controller;

import com.oocl.grow.model.Todo;
import com.oocl.grow.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoRestController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping("/todos")
    public Todo createDodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }
}
