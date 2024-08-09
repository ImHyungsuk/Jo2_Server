package com.jo2.server.member.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    TEMP("임시 코드");

    private final String message;
}
