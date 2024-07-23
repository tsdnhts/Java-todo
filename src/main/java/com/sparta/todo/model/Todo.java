package com.sparta.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonIgnore
    private Long id;
    private String title;
    private String description;
    private String manager;
    private String password;
    private LocalDateTime createdDate; // 작성일
    private LocalDateTime updatedDate; // 수정일
}
