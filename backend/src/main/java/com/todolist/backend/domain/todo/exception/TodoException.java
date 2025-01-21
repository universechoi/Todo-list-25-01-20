package com.todolist.backend.domain.todo.exception;

import com.todolist.backend.domain.exception.DomainException;
import com.todolist.backend.global.exception.ErrorCode;

public class TodoException extends DomainException {
  public TodoException(ErrorCode errorCode) {
    super(errorCode);
  }
}
