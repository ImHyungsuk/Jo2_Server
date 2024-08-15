package com.jo2.server.weather.dto.reponse;

import com.jo2.server.weather.entity.WeatherList;

public record AllWeatherResponse(
        WeatherList recentWeathers
) {
    public static AllWeatherResponse from(WeatherList recentWeathers) {
        return new AllWeatherResponse(recentWeathers);
    }
}
