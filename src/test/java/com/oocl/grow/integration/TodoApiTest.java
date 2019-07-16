package com.oocl.grow.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.Todo;
import com.oocl.grow.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TodoApiTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    TodoRepository todoRepository;

    @Test
    public void should_get_all_todos() throws Exception {
        List<Todo> todos = Arrays.asList(new Todo(1l, "clean room", false), new Todo(2l, "cook meal", false));
        todoRepository.saveAll(todos);

        mvc.perform(get("/api/todos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void should_create_todo() throws Exception {
        // given
        Todo todo = Todo.builder().text("learn tdd").completed(false).build();
        String json = new ObjectMapper().writeValueAsString(todo);

        mvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.text", equalTo("learn tdd")))
                .andExpect(jsonPath("$.completed", equalTo(false)));
    }

}
