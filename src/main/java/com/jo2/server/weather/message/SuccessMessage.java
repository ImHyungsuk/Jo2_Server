package com.jo2.server.weather.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    SUCCESS_GET_RECENT_RESULT("최근 날씨 불러오기 성공"),
    SUCCESS_GET_ALL_RESULT("전체 날씨 불러오기 성공");

    private final String message;
}
