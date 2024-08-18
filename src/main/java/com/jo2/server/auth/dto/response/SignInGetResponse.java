package com.jo2.server.auth.dto.response;

public record SignInGetResponse(
        String accessToken,
        String refreshToken
) {
    public static SignInGetResponse of(final String accessToken, final String refreshToken) {
        return new SignInGetResponse(accessToken,refreshToken);
    }
}