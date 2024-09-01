package com.jo2.server.chatserver.client.dto;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jo2.server.weather.vo.WeatherVO;
import io.micrometer.common.lang.NonNull;
import java.time.LocalDate;
import lombok.Builder;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder(access = PRIVATE)
public record ChatServerAnalysisDataRequest(
        @NonNull String result,
        @NonNull int score,
        @NonNull int phqScore,
        @NonNull LocalDate date
) {
    public static ChatServerAnalysisDataRequest from(WeatherVO weatherVO){
        return ChatServerAnalysisDataRequest.builder()
                .result(weatherVO.result())
                .score(weatherVO.scoreVO().getScore())
                .phqScore(weatherVO.phqScoreVO().getPhqscore())
                .date(weatherVO.createdAt().toLocalDate())
                .build();
    }
}