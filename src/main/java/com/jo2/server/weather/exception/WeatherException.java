package com.jo2.server.weather.exception;

import com.jo2.server.weather.message.ErrorCode;
import lombok.Getter;

@Getter
public class WeatherException extends RuntimeException {

    private final ErrorCode errorCode;

    public WeatherException(ErrorCode errorCode) {
        super("[WeatherException] : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
