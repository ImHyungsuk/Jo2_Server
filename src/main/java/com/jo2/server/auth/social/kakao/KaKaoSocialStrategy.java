package com.jo2.server.auth.social.kakao;

import com.jo2.server.auth.dto.request.UserSignInRequest;
import com.jo2.server.auth.exception.AuthException;
import com.jo2.server.auth.message.ErrorCode;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.auth.social.kakao.api.KakaoAccessTokenClient;
import com.jo2.server.auth.social.kakao.api.KakaoUserClient;
import com.jo2.server.auth.social.kakao.api.dto.KakaoAccessTokenResponse;
import com.jo2.server.auth.social.kakao.api.dto.KakaoUserResponse;
import com.jo2.server.auth.strategy.SignInStrategy;
import com.jo2.server.auth.strategy.dto.UserInfoResponse;
import feign.FeignException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KaKaoSocialStrategy implements SignInStrategy {

    private final KakaoAccessTokenClient kakaoAccessTokenClient;
    private final KakaoUserClient kakaoUserClient;

    @Value("${KAKAO.clientId}")
    private String clientId;

    private static final String AUTH_CODE = "authorization_code";
    @Getter
    private final SocialType socialType = SocialType.KAKAO;

    @Override
    public UserInfoResponse login(final String authorizationCode, final UserSignInRequest signInRequest) {
        String accessToken;
        try {
            accessToken = getOAuth2Authentication(signInRequest.redirectUri(), authorizationCode);
        } catch (FeignException e) {
            log.info(String.valueOf(e));
            throw new AuthException(ErrorCode.AUTHENTICATION_CODE_EXPIRED);
        }
        KakaoUserResponse response = getUserInfo(accessToken);
        return getLoginDto(signInRequest.socialType(), response.id(), response.kakaoAccount().profile().nickname());
    }

    private String getOAuth2Authentication(
            final String redirectUri,
            final String authorizationCode
    ) {
        KakaoAccessTokenResponse response = kakaoAccessTokenClient.getOAuth2AccessToken(
                AUTH_CODE,
                clientId,
                redirectUri,
                authorizationCode
        );
        return "Bearer " + response.accessToken();
    }

    @Override
    public void revokeUser(String authorizationCode, UserSignInRequest signInRequest) {

    }
    private KakaoUserResponse getUserInfo(
            final String accessToken
    ) {
        return kakaoUserClient.getUserInformation(accessToken);
    }

    public UserInfoResponse getLoginDto(
            final SocialType socialType,
            final Long socialId,
            final String nickname
    ) {
        return UserInfoResponse.of(
                socialId.toString(),
                socialType,
                nickname
        );
    }
}
