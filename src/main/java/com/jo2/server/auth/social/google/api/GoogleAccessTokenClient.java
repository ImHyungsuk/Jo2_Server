package com.jo2.server.auth.social.google.api;

import com.jo2.server.auth.social.google.api.dto.GoogleAccessTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleAccessTokenClient", url = "https://oauth2.googleapis.com")
public interface GoogleAccessTokenClient {
    @PostMapping("/token")
    GoogleAccessTokenResponse getAccessToken(
            @RequestParam(name = "code") String code,
            @RequestParam(name = "clientId") String clientId,
            @RequestParam(name = "clientSecret") String clientSecret,
            @RequestParam(name = "redirectUri") String redirectUri,
            @RequestParam(name = "grantType") String grantType
    );
}