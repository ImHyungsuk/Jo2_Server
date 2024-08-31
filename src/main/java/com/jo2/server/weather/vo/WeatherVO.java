package com.jo2.server.weather.vo;

import static lombok.AccessLevel.PRIVATE;

import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.entity.PhqScoreVO;
import com.jo2.server.weather.entity.ScoreVO;
import com.jo2.server.weather.entity.Weather;
import io.micrometer.common.lang.NonNull;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(access = PRIVATE)
public record WeatherVO(
        @NonNull Member member,
        @NonNull ScoreVO scoreVO,
        @NonNull PhqScoreVO phqScoreVO,
        @NonNull String result,
        @NonNull LocalDateTime dateTime
) {
    public static WeatherVO from(Weather weather) {
        return WeatherVO.builder()
                .scoreVO(weather.getScoreVO())
                .phqScoreVO(weather.getPhqScoreVO())
                .result(weather.getResult())
                .dateTime(weather.getCreatedAt())
                .build();
    }
}
