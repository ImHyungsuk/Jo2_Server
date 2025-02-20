package com.jo2.server.chatserver.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    SUCCESS_START_CHATTING("새로운 채팅이 시작되었습니다."),
    SUCCESS_ANALYSIS("분석이 완료되었습니다.");

    private final String message;
}
