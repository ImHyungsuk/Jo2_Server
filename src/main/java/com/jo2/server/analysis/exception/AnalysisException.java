package com.jo2.server.analysis.exception;

import com.jo2.server.member.message.ErrorCode;
import lombok.Getter;

@Getter
public class AnalysisException extends RuntimeException {
    private final ErrorCode errorCode;

    public AnalysisException(ErrorCode errorCode){
        super("[AnalysisException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
