package com.jo2.server.auth.strategy.dto;

import com.jo2.server.auth.social.SocialType;

public record UserInfoResponse(
        String socialId,
        SocialType socialType,
        String nickname
) {
    public static UserInfoResponse of(
            final String socialId,
            final SocialType socialType,
            final String nickname
    ) {
        return new UserInfoResponse(socialId, socialType, nickname);
    }
}