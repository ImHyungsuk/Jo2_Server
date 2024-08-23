package com.jo2.server.contents.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessMessage {
    SUCCESS_MAIN_SENTENCES("메인 문구 불러오기 성공"),
    SUCCESS_VIDEO_CARDS("비디오 카드 불러오기 성공");

    private final String message;
}
