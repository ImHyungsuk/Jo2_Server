package com.jo2.server.chatserver.client.dto;

import com.jo2.server.weather.entity.Weather;
import java.util.List;

public record ChatServerAnalysisRequest(
        List<Weather> weatherList
) {
    public static ChatServerAnalysisRequest of(List<Weather> weatherList) {
        return new ChatServerAnalysisRequest(weatherList);
    }
}
