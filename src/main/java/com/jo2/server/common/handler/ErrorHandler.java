package com.jo2.server.common.handler;

import com.jo2.server.common.dto.BaseResponse;
import com.jo2.server.common.dto.ErrorResponse;
import com.jo2.server.weather.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({WeatherException.class})
    protected ResponseEntity<BaseResponse>weatherException(WeatherException exception) {
        log.error(exception.getMessage());
        val errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }

}
