package com.jo2.server.auth.dto.response;

public record SignInGetResponse(
        String accessToken,
        String refreshToken,
        String nickname
) {
    public static SignInGetResponse of(final String accessToken, final String refreshToken, String nickname) {
        return new SignInGetResponse(accessToken, refreshToken, nickname);
    }
}