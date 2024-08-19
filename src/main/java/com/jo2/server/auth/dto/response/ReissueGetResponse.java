package com.jo2.server.auth.dto.response;

public record ReissueGetResponse(
        String accessToken
) {
    public static ReissueGetResponse from(final String refreshToken) {
        return new ReissueGetResponse(refreshToken);
    }
}
