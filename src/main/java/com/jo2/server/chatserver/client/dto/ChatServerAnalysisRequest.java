package com.jo2.server.chatserver.client.dto;

import com.jo2.server.weather.entity.Weather;
import java.util.List;

public record ChatServerAnalysisRequest(
        long user_id,
        List<Weather> weatherList
) {
    public static ChatServerAnalysisRequest of(Long user_id, List<Weather> weatherList) {
        return new ChatServerAnalysisRequest(user_id, weatherList);
    }
}
