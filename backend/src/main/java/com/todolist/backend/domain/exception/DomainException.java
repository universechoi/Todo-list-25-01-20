package com.todolist.backend.domain.exception;

import com.todolist.backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    private final ErrorCode errorCode;

    public DomainException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}