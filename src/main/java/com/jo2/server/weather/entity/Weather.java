package com.jo2.server.weather.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.jo2.server.common.entity.BaseTime;
import com.jo2.server.member.entity.Member;
import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
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

    @Embedded
    private ScoreVO scoreVO;

    private DayOfWeek dayOfWeek;

    private String result;

    public static Weather of(
            Member member,
            int score,
            String result,
            LocalDate localDate
    ) {
        return Weather.builder()
                .member(member)
                .scoreVO(ScoreVO.from(score))
                .dayOfWeek(localDate.getDayOfWeek())
                .result(result)
                .build();
    }

}
