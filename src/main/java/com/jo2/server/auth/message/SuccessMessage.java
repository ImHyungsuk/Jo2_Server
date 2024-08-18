package com.jo2.server.auth.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    SUCCESS_SIGN_IN_INFOR("로그인 성공");
    private final String message;
}
