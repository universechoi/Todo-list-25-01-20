package com.todolist.backend.domain.user.entity;

import com.todolist.backend.domain.todo.entity.Todo;
import com.todolist.backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Email(message = "잘못된 이메일 형식입니다.")
    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(max = 10, message = "이름은 10자 이내여야 합니다.")
    @Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @NotEmpty
    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @Column(name = "user_password", nullable = false)
    private String password;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todoList = new ArrayList<>();
}