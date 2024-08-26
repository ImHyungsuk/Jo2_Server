package com.jo2.server.weather.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.repository.WeatherRepository;
import java.security.PublicKey;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class WeatherSaver {
    private final WeatherRepository weatherRepository;

    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }
}
