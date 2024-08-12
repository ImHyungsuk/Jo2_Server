package com.jo2.server.weather.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class WeatherFinder {
    private final WeatherRepository weatherRepository;
}
