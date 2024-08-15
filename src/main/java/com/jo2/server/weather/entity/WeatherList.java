package com.jo2.server.weather.entity;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WeatherList {
    private final List<Weather> weatherList;

    public static WeatherList from(List<Weather> weatherList) {
        return new WeatherList(weatherList);
    }
}
