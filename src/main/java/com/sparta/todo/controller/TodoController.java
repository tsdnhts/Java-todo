package com.sparta.todo.controller;

import com.sparta.todo.dto.TodoDTO;
import com.sparta.todo.dto.TodoUpdateRequest;
import com.sparta.todo.model.Todo;
import com.sparta.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo", description = "일정 API")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    @Operation(summary = "모든 일정 조회", description = "등록된 모든 일정을 조회합니다.")
    public List<TodoDTO> getAllTodos() {
        return todoService.findAll().stream()
                .map(TodoDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "선택한 일정 조회", description = "선택한 일정의 정보를 조회합니다.")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id) {
        return todoService.findById(id)
                .map(todo -> ResponseEntity.ok(new TodoDTO(todo)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "일정을 찾을 수 없습니다."));
    }

    @PostMapping
    @Operation(summary = "일정 생성", description = "새로운 일정을 생성합니다.")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody Todo todo) {
        todo.setCreatedDate(LocalDateTime.now());
        todo.setUpdatedDate(LocalDateTime.now());
        Todo createdTodo = todoService.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TodoDTO(createdTodo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "선택한 일정 수정", description = "선택한 일정을 수정합니다.")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long id, @RequestBody TodoUpdateRequest request, @RequestParam String password) {
        if (!todoService.verifyPassword(id, password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
        }
        Todo todo = request.toTodo();
        todo.setId(id);
        todo.setUpdatedDate(LocalDateTime.now());
        Todo updatedTodo = todoService.save(todo);
        return ResponseEntity.ok(new TodoDTO(updatedTodo));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "선택한 일정 삭제", description = "선택한 일정을 삭제합니다.")
    public void deleteTodoById(@PathVariable Long id, @RequestParam String password) {
        if (!todoService.verifyPassword(id, password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
        }
        todoService.deleteById(id);
    }

}
