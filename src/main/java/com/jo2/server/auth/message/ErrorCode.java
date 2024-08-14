package com.jo2.server.auth.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    TEMP(HttpStatus.BAD_REQUEST,"임시코드");
    private final HttpStatus httpStatus;
    private final String message;

}
