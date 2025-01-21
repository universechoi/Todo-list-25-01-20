package com.todolist.backend.global.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.todolist.backend.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Boolean isSuccess;
    private String resultCode;
    private String message;
    private T data;

    public ApiResponse(Boolean isSuccess, String resultCode, String message) {
        this.isSuccess = isSuccess;
        this.resultCode = resultCode;
        this.message = message;
        this.data = null;
    }

    public static <T> ApiResponse<T> success(String resultCode, String message, T data) {
        return new ApiResponse<>(true, resultCode, message, data);
    }

    public static <T> ApiResponse<T> error(ErrorCode errorCode) {
        return new ApiResponse<>(false, errorCode.getCode(), errorCode.getMessage());
    }

    @JsonIgnore
    public int getStatusCode() {
        return Integer.parseInt(resultCode);
    }
}