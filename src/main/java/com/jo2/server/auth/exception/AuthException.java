package com.jo2.server.auth.exception;

import com.jo2.server.auth.message.ErrorCode;
import lombok.Getter;

@Getter
public class AuthException extends RuntimeException{
    private final ErrorCode errorCode;

    public AuthException(ErrorCode errorCode) {
        super("[AuthException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
