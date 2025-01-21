package com.todolist.backend.domain.todo.entity;

import com.todolist.backend.domain.user.entity.User;
import com.todolist.backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @Column(name = "todo_id", nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "할 일은 필수 항목입니다.")
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String todo;

    @Size(max = 500, message = "설명은 500자 이하로 입력해주세요.")
    @Column(columnDefinition = "TEXT")
    private String description;

    @FutureOrPresent(message = "마감일은 현재 시점 또는 미래여야 합니다.")
    @Column(name = "due_date", nullable = false, updatable = false)
    private LocalDateTime dueDate;

    @NotNull(message = "완료 여부를 설정해 주세요.")
    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}