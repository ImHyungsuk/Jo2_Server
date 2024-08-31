package com.jo2.server.chatserver.client.dto;

import static lombok.AccessLevel.PRIVATE;

import com.jo2.server.weather.entity.PhqScoreVO;
import com.jo2.server.weather.entity.ScoreVO;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.vo.WeatherVO;
import io.micrometer.common.lang.NonNull;
import lombok.Builder;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


@Builder(access = PRIVATE)
public record WeatherAnalysisVO(
        @NonNull String result,
        @NonNull int score,
        @NonNull int phqscore,
        @NonNull LocalDateTime createdAt,
        @NonNull LocalDateTime updatedAt
) {
    public static WeatherAnalysisVO from(Weather weather){
        return WeatherAnalysisVO.builder()
                .result(weather.getResult())
                .score(weather.getScoreVO().getScore())
                .phqscore(weather.getPhqScoreVO().getPhqscore())
                .createdAt(weather.getCreatedAt())
                .updatedAt(weather.getUpdatedAt())
                .build();
    }
}
