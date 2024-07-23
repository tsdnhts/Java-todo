package com.sparta.todo.service;

import com.sparta.todo.model.Todo;
import com.sparta.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByCreatedDateDesc();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public boolean verifyPassword(Long id, String password) {
        return todoRepository.findById(id)
                .map(todo -> todo.getPassword().equals(password))
                .orElse(false);
    }
}
