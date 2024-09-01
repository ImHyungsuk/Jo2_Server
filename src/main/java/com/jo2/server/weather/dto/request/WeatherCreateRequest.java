package com.jo2.server.weather.dto.request;

public record  WeatherCreateRequest(
        int userId,
        int overallScore,
        int phq9Score,
        String summary
) {
}