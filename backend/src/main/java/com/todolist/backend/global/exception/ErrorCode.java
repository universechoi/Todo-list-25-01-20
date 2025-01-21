package com.todolist.backend.global.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    //Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, false, "C001", "올바르지 않은 입력값"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, false, "C002", "올바르지 않은 HTTP 메서드"),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, false, "C003", "값을 찾지 못함"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, false, "C004", "요청이 거부됨"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "C005", "서버 내부 오류 발생"),

    //Todo
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, false, "P001", "요청한 Todo 항목가 존재하지 않음"),

    //User
    EMAIL_DUPLICATION(HttpStatus.BAD_REQUEST, false, "U001", "이미 사용중인 이메일"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, false, "U002", "회원 정보가 존재하지 않음"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, false, "U003", "잘못된 자격 증명"),
    PASSWORD_SAME_AS_CURRENT(HttpStatus.BAD_REQUEST, false, "U004", "새 비밀번호가 현재 비밀번호와 동일"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, false, "U006", "비밀번호 불일치"),
    UNAUTHENTICATION_USER(HttpStatus.UNAUTHORIZED, false, "U007", "인증되지 않은 사용자");

    private final HttpStatus status;
    private final boolean    isSuccess;
    private final String     code;
    private final String     message;
}
