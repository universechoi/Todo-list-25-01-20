package com.todolist.backend.global.initData;

import com.todolist.backend.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    @Lazy
    @Autowired
    private BaseInitData self;

    private final TodoService todoService;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work();
        };
    }

    public void work() {
        for (int i = 0; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용 없음";
        }
    }
}