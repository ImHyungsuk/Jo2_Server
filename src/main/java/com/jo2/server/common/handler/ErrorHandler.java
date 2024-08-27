package com.jo2.server.common.handler;

import com.jo2.server.analysis.exception.AnalysisException;
import com.jo2.server.auth.exception.AuthException;
import com.jo2.server.chatserver.exception.ChatserverException;
import com.jo2.server.common.dto.BaseResponse;
import com.jo2.server.common.dto.ErrorResponse;
import com.jo2.server.member.exception.MemberException;
import com.jo2.server.weather.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(WeatherException.class)
    protected ResponseEntity<BaseResponse> weatherException(WeatherException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(AuthException.class)
    protected ResponseEntity<BaseResponse> authException(AuthException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(ChatserverException.class)
    protected ResponseEntity<BaseResponse> chatServerException(ChatserverException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<BaseResponse> memberException(MemberException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

    @ExceptionHandler(AnalysisException.class)
    protected ResponseEntity<BaseResponse> analysisException(AnalysisException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }
}
