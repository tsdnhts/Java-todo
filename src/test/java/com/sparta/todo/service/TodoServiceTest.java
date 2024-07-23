//package com.sparta.todo.service;
//
//import com.sparta.todo.model.Todo;
//import com.sparta.todo.repository.TodoRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@ActiveProfiles("test") // 테스트 프로파일을 사용할 경우
//public class TodoServiceTest {
//
//    @Autowired
//    private TodoRepository todoRepository;
//
//    private Todo todo;
//
//    @BeforeEach
//    public void setUp() {
//        todo = new Todo();
//        todo.setTitle("Test Title");
//        todo.setDescription("Test Description");
//        todo.setManager("Test Manager");
//        todo.setPassword("TestPassword");
//        todo.setCreatedDate(LocalDateTime.now());
//        todo.setUpdatedDate(LocalDateTime.now());
//    }
//
//    @Test
//    public void testCreateTodo() {
//        Todo savedTodo = todoRepository.save(todo);
//        assertNotNull(savedTodo.getId(), "Todo ID should not be null");
//        assertEquals("Test Title", savedTodo.getTitle(), "Title should match");
//    }
//
//    @Test
//    public void testReadTodo() {
//        Todo savedTodo = todoRepository.save(todo);
//        Optional<Todo> foundTodo = todoRepository.findById(savedTodo.getId());
//        assertTrue(foundTodo.isPresent(), "Todo should be found");
//        assertEquals("Test Title", foundTodo.get().getTitle(), "Title should match");
//    }
//
//    @Test
//    public void testUpdateTodo() {
//        Todo savedTodo = todoRepository.save(todo);
//        savedTodo.setTitle("Updated Title");
//        todoRepository.save(savedTodo);
//        Optional<Todo> updatedTodo = todoRepository.findById(savedTodo.getId());
//        assertTrue(updatedTodo.isPresent(), "Todo should be found");
//        assertEquals("Updated Title", updatedTodo.get().getTitle(), "Title should be updated");
//    }
//
//    @Test
//    public void testDeleteTodo() {
//        Todo savedTodo = todoRepository.save(todo);
//        todoRepository.deleteById(savedTodo.getId());
//        Optional<Todo> deletedTodo = todoRepository.findById(savedTodo.getId());
//        assertFalse(deletedTodo.isPresent(), "Todo should be deleted");
//    }
//}
