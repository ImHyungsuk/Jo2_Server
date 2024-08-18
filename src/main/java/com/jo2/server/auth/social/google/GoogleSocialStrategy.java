package com.jo2.server.auth.social.google;

import com.jo2.server.auth.dto.request.UserSignInRequest;
import com.jo2.server.auth.exception.AuthException;
import com.jo2.server.auth.message.ErrorCode;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.auth.social.google.api.GoogleAccessTokenClient;
import com.jo2.server.auth.social.google.api.GoogleUserClient;
import com.jo2.server.auth.social.google.api.dto.GoogleUserInfoResponse;
import com.jo2.server.auth.strategy.SignInStrategy;
import com.jo2.server.auth.strategy.dto.UserInfoResponse;
import feign.FeignException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleSocialStrategy implements SignInStrategy {

    private final GoogleAccessTokenClient googleAccessTokenClient;
    private final GoogleUserClient googleUserClient;

    @Getter
    private final SocialType socialType = SocialType.GOOGLE;

    private static final String GRANT_TYPE = "authorization_code";

    @Value("${GOOGLE.clientId}")
    private String clientId;
    @Value("${GOOGLE.clientSecret}")
    private String clientSecret;

    @Override
    public UserInfoResponse login(final String authorizationCode, final UserSignInRequest loginRequest) {
        String accessToken = "";
        try {
            accessToken = getOAuth2Authentication(authorizationCode, loginRequest.redirectUri());
        } catch (FeignException e) {
            throw new AuthException(ErrorCode.AUTHENTICATION_CODE_EXPIRED);
        }
        GoogleUserInfoResponse response = getGoogleUserInfo(accessToken);
        return getLoginDto(loginRequest.socialType(), response.id(), response.email());
    }

    private String getOAuth2Authentication(
            final String authorizationCode,
            final String redirectUri
    ) {
        return googleAccessTokenClient.getAccessToken(
                authorizationCode,
                clientId,
                clientSecret,
                redirectUri,
                GRANT_TYPE
        ).accessToken();
    }

    private GoogleUserInfoResponse getGoogleUserInfo(
            final String accessToken
    ) {
        return googleUserClient.getGoogleUserInfo(accessToken);
    }

    @Override
    public void revokeUser(String authorizationCode, UserSignInRequest signInRequest) {

    }
}
