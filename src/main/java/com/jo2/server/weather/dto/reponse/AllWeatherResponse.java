package com.jo2.server.weather.dto.reponse;

import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;

public record AllWeatherResponse(
        List<WeatherVO> recentWeathers
) {
    public static AllWeatherResponse from(List<Weather> recentWeathers) {
        return new AllWeatherResponse(recentWeathers.stream().map(WeatherVO::from).toList());
    }
}
