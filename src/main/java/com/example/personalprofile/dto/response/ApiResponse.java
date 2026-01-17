package com.example.personalprofile.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private int code;
    private T data;

    public ApiResponse(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
