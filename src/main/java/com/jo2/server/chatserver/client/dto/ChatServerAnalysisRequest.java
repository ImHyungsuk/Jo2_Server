package com.jo2.server.chatserver.client.dto;

import com.jo2.server.weather.entity.Weather;
import java.util.List;

public record ChatServerAnalysisRequest(
        List<WeatherAnalysisVO> weatherList
) {
    public static ChatServerAnalysisRequest from(List<Weather> weatherList) {
        return new ChatServerAnalysisRequest(weatherList.stream().map(WeatherAnalysisVO::from).toList());
    }
}
