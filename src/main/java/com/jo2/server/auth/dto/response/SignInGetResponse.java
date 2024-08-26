package com.jo2.server.auth.dto.response;

public record SignInGetResponse(
        String accessToken,
        String refreshToken,
        String nickname,
        Long user_id
) {
    public static SignInGetResponse of(final String accessToken, final String refreshToken, String nickname, Long user_id) {
        return new SignInGetResponse(accessToken, refreshToken, nickname, user_id);
    }
}