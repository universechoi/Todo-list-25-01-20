package com.todolist.backend.domain.user.exception;

import com.todolist.backend.domain.exception.DomainException;
import com.todolist.backend.global.exception.ErrorCode;

public class UserExceptipn extends DomainException {
    public UserExceptipn(ErrorCode errorCode) {
        super(errorCode);
    }
}
