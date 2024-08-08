package com.jo2.server.member.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("남자"),
    FEMALE("여자"),
    THIRD_SEX("제 3의 성");

    private final String gender;
}
