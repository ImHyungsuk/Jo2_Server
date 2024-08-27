package com.jo2.server.auth.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    AUTHENTICATION_CODE_EXPIRED(HttpStatus.BAD_REQUEST,"인증 코드 만료"),
    UN_LOGIN_EXCEPTION(HttpStatus.UNAUTHORIZED,"로그인 후 진행해 주세요"),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST,"토큰 값 오류"),
    BEARER_LOST_ERROR(HttpStatus.BAD_REQUEST,"토큰의 요청에 Bearer이 담겨 있지 않습니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 유저의 리프레시 토큰이 존재하지 않습니다"),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
