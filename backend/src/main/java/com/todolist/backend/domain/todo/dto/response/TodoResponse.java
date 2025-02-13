package com.todolist.backend.domain.todo.dto.response;

import java.time.LocalDate;

public record TodoResponse(
        Long id,
        String todo,
        String description,
        LocalDate dueDate,
        Boolean isCompleted
) {}
