package com.sparta.todo.dto;

import com.sparta.todo.model.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoDTO {
    // @JsonIgnore
    private Long id;
    private String title;
    private String description;
    private String manager;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public TodoDTO(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.manager = todo.getManager();
        this.createdDate = todo.getCreatedDate();
        this.updatedDate = todo.getUpdatedDate();
    }
}
