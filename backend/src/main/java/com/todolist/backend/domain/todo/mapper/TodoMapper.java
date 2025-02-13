package com.todolist.backend.domain.todo.mapper;

import com.todolist.backend.domain.todo.dto.response.TodoResponse;
import com.todolist.backend.domain.todo.entity.Todo;

public class TodoMapper {
    public static TodoResponse toResponse(Todo todo) {
        return new com.todolist.backend.domain.todo.dto.response.TodoResponse(
                todo.getId(),
                todo.getTodo(),
                todo.getDescription(),
                todo.getDueDate(),
                todo.isCompleted()
        );
    }
}
