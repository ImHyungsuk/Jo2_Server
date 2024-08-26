package com.jo2.server.auth.dto.response;

public record SignInGetResponse(
        String accessToken,
        String refreshToken,
        String nickname,
        Long memberId
) {
    public static SignInGetResponse of(final String accessToken, final String refreshToken, String nickname, Long memberId) {
        return new SignInGetResponse(accessToken, refreshToken, nickname, memberId);
    }
}