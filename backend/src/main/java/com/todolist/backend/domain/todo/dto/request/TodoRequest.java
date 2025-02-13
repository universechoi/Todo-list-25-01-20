package com.todolist.backend.domain.todo.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TodoRequest {
    public record Create(
            @NotBlank
            @Size(max = 255)
            String todo,

            @Size(max = 500)
            String description,

            @FutureOrPresent
            LocalDate dueDate,

            Boolean isCompleted
    ) {}

    public record Update(
            @Size(max = 255)
            String todo,

            @Size(max = 500)
            String description,

            @FutureOrPresent
            LocalDate dueDate,

            Boolean isCompleted
    ) {}
}
