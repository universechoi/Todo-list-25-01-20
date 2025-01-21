package com.todolist.backend.domain.todo.repository;

import com.todolist.backend.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}