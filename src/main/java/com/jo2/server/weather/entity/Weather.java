package com.jo2.server.weather.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.jo2.server.common.entity.BaseTime;
import com.jo2.server.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Weather extends BaseTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "weather_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private int score;
    private LocalDate date;

    public static Weather of(
            Member member,
            int score,
            LocalDate date
    ){
        return Weather.builder()
                .member(member)
                .score(score)
                .date(date)
                .build();
    }
}
