package com.jo2.server.chatserver.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NONE_EXIST_DATA(HttpStatus.BAD_REQUEST, "검사 기록이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
