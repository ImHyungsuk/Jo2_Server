package com.jo2.server.member.exception;


import com.jo2.server.member.message.ErrorCode;
import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {

    private final ErrorCode errorCode;

    public MemberException(ErrorCode errorCode) {
        super("[MemberException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
