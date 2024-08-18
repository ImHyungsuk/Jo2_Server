package com.jo2.server.auth.dto.request;

import com.jo2.server.auth.social.SocialType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserSignInRequest(
        @NotBlank
        String redirectUri,
        @NotNull(message = "소셜 로그인 종류가 입력되지 않았습니다.")
        SocialType socialType
) {
}
