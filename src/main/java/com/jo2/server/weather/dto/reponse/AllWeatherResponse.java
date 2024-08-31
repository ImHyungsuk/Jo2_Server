package com.jo2.server.weather.dto.reponse;

import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;

public record AllWeatherResponse(
        List<WeatherResponse> recentWeathers
) {
    public static AllWeatherResponse from(List<WeatherVO> recentWeathers) {
        return new AllWeatherResponse(recentWeathers.stream().map(WeatherResponse::from).toList());
    }
}
