package com.todolist.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the API!";
    }
}