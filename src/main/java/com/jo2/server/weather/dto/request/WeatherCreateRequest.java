package com.jo2.server.weather.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public record  WeatherCreateRequest(
        int userId,
        int overallScore,
        String overallAnalyze
) {
}
