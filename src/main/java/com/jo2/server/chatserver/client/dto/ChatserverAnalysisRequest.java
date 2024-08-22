package com.jo2.server.chatserver.client.dto;

import com.jo2.server.weather.entity.WeatherList;

public record ChatserverAnalysisRequest(
        long user_id,
        WeatherList weatherList
) {
    public static ChatserverAnalysisRequest from(Long user_id, WeatherList weatherList) {
        return new ChatserverAnalysisRequest(user_id, weatherList);
    }
}
