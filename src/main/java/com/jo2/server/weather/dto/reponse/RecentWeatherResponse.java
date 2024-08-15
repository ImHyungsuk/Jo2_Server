package com.jo2.server.weather.dto.reponse;

public record RecentWeatherResponse(
        int score
) {

    public static RecentWeatherResponse from(int score) {
        return new RecentWeatherResponse(score);
    }
}
