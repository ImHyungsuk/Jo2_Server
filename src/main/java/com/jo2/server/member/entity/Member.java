package com.jo2.server.member.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

import com.jo2.server.common.entity.BaseTime;
import com.jo2.server.member.entity.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(value = STRING)
    private Gender gender;

    private LocalDate birth;

    public static Member of(
            String email,
            String password,
            String name,
            LocalDate birth,
            Gender gender
            ) {

        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .birth(birth)
                .gender(gender)
                .build();
    }
}