//package com.sparta.todo.controller;
//
//import com.sparta.todo.model.Todo;
//import com.sparta.todo.service.TodoService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalDateTime;
//import java.util.Collections;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@WebMvcTest(TodoController.class)
//public class TodoControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TodoService todoService;
//
//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new TodoController()).build();
//    }
//
//    @Test
//    public void testCreateTodo() throws Exception {
//        Todo todo = new Todo();
//        todo.setTitle("Test Title");
//        todo.setDescription("Test Description");
//        todo.setManager("Test Manager");
//        todo.setPassword("TestPassword");
//        todo.setCreatedDate(LocalDateTime.now());
//        todo.setUpdatedDate(LocalDateTime.now());
//
//        given(todoService.save(todo)).willReturn(todo);
//
//        mockMvc.perform(post("/api/todos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"title\":\"Test Title\",\"description\":\"Test Description\",\"manager\":\"Test Manager\",\"password\":\"TestPassword\",\"createdDate\":\"2024-07-23T20:27:16\",\"updatedDate\":\"2024-07-23T20:27:16\"}"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Title"));
//    }
//
//    // 추가적인 통합 테스트 작성
//}
