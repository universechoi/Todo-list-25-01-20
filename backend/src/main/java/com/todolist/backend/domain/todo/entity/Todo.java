package com.todolist.backend.domain.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String todo;

    @Size(max = 500)
    @Column(columnDefinition = "TEXT")
    private String description;

    @FutureOrPresent
    private LocalDate dueDate;

    @Column(nullable = false)
    private boolean isCompleted = false;

    @NotNull
    @Column(nullable = false)
    private Long userId;

    // private -> 객체 생성시 Builder 강제 ->  Builder 는 생성자가 아니라 build() 메서드로 객체를 생성
    @Builder
    private Todo(String todo, String description, LocalDate dueDate, Long userId) {
        this.todo = todo;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
        this.userId = userId;
    }
}