package com.jo2.server.analysis.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    TEMP("임시 코드");

    private final String message;
}
