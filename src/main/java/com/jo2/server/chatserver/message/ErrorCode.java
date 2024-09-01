package com.jo2.server.chatserver.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NONE_EXIST_DATA(HttpStatus.BAD_REQUEST, "검사 기록이 존재하지 않습니다."),
    INVALID_DATA_TYPE(HttpStatus.INTERNAL_SERVER_ERROR,"잘못된 서버응답입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
