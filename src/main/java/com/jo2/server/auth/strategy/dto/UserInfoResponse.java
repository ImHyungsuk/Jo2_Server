package com.jo2.server.auth.strategy.dto;

import com.jo2.server.auth.social.SocialType;

public record UserInfoResponse(
        String socialId,
        SocialType socialType,
        String email
) {
    public static UserInfoResponse of(
            final String socialId,
            final SocialType socialType,
            final String email
    ) {
        return new UserInfoResponse(socialId, socialType, email);
    }
}