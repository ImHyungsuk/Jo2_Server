package com.jo2.server.auth.social;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocialType {
    KAKAO("KAKAO"),
    GOOGLE("GOOGLE"),
    //NAVER("NAVER"),
    ;
    private final String socialType;
}