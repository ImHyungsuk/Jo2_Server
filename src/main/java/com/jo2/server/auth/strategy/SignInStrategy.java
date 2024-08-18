package com.jo2.server.auth.strategy;

import com.jo2.server.auth.dto.request.UserSignInRequest;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.auth.strategy.dto.UserInfoResponse;

public interface SignInStrategy {
    UserInfoResponse login(final String authorizationCode, final UserSignInRequest signInRequest);
    default UserInfoResponse getLoginDto(final SocialType socialType, final String clientId, final String email) {
        return UserInfoResponse.of(clientId, socialType, email);
    }
    void revokeUser(final String authorizationCode,final UserSignInRequest signInRequest);
    SocialType getSocialType();
}
