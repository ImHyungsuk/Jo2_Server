package com.jo2.server.weather.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    TEMP("임시코드");

    private final String message;
}
