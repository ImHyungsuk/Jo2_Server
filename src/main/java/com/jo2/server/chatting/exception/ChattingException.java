package com.jo2.server.chatting.exception;

import com.jo2.server.chatting.message.ErrorCode;
import lombok.Getter;

@Getter
public class ChattingException extends RuntimeException {

    private final ErrorCode errorCode;

    public ChattingException(ErrorCode errorCode){
        super("[ChattingException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
