package com.jo2.server.auth.social.kakao.api;

import com.jo2.server.auth.social.kakao.api.dto.KakaoAccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "kakaoAccessTokenClient", url = "https://kauth.kakao.com")
public interface KakaoAccessTokenClient {
    @PostMapping(value = "/oauth/token")
    KakaoAccessTokenResponse getOAuth2AccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}