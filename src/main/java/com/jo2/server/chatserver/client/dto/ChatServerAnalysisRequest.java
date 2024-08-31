package com.jo2.server.chatserver.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ChatServerAnalysisRequest(
        List<ChatServerAnalysisDataRequest> weatherList
) {
    public static ChatServerAnalysisRequest from(List<WeatherVO> weatherList) {
        return new ChatServerAnalysisRequest(weatherList.stream().map(ChatServerAnalysisDataRequest::from).toList());
    }
}
