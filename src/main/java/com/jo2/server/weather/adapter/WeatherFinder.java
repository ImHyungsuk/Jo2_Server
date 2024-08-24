package com.jo2.server.weather.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.entity.WeatherList;
import com.jo2.server.weather.repository.WeatherRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class WeatherFinder {
    private final WeatherRepository weatherRepository;

    public Optional<Weather> findTopByMemberIdOrderByCreatedAtDesc(long memberId){
        return weatherRepository.findTopByMemberIdOrderByCreatedAtDesc(memberId);
    }

    public WeatherList findAllById(long memberId){
        return WeatherList.from(weatherRepository.findAllById(memberId));
    }
}
