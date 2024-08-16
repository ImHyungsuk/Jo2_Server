package com.jo2.server.chatserver.exception;

import com.jo2.server.chatserver.message.ErrorCode;
import lombok.Getter;

@Getter
public class ChatserverException extends RuntimeException {

    private final ErrorCode errorCode;

    public ChatserverException(ErrorCode errorCode){
        super("[ChattingException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
