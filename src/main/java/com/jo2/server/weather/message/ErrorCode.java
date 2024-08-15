package com.jo2.server.weather.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    RANGE_EXCEPTION(HttpStatus.BAD_REQUEST, "점수의 범위는 1부터 100까지 입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
