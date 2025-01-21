package com.todolist.backend.global.aspect;

import com.todolist.backend.global.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ResponseAspect {
    private final HttpServletResponse response;

    @Around("""
            (
                within
                (
                    @org.springframework.web.bind.annotation.RestController *
                )
                &&
                (
                    @annotation(org.springframework.web.bind.annotation.GetMapping)
                    ||
                    @annotation(org.springframework.web.bind.annotation.PostMapping)
                    ||
                    @annotation(org.springframework.web.bind.annotation.PutMapping)
                    ||
                    @annotation(org.springframework.web.bind.annotation.DeleteMapping)
                    ||
                    @annotation(org.springframework.web.bind.annotation.RequestMapping)
                )
            )
            ||
            @annotation(org.springframework.web.bind.annotation.ResponseBody)
            """)

    public Object handleResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        if (result instanceof ApiResponse<?> apiResponse) {
            response.setStatus(apiResponse.getStatusCode());
        }
        return result;
    }
}
