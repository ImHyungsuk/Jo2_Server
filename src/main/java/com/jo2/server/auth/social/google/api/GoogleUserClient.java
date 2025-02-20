package com.jo2.server.auth.social.google.api;

import com.jo2.server.auth.social.google.api.dto.GoogleUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "googleUserClient", url = "https://www.googleapis.com")
public interface GoogleUserClient {
    @GetMapping("/userinfo/v2/me")
    GoogleUserInfoResponse getGoogleUserInfo(@RequestParam(value = "access_token") final String accessToken);

}