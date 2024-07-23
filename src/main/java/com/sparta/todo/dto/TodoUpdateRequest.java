package com.sparta.todo.dto;

import com.sparta.todo.model.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateRequest {
    private String title;
    private String description;
    private String manager;

    public Todo toTodo() {
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        todo.setManager(this.manager);
        // 비밀번호는 포함하지 않도록 설정
        return todo;
    }
}
