package com.jo2.server.chatting.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    SUCCESS_START_CHATTING("새로운 채팅이 시작되었습니다."),
    SUCCESS_END_CHATTING("채팅이 종료되었습니다.");

    private final String message;
}
